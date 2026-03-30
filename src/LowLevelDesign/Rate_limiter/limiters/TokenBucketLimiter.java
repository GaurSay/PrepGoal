package LowLevelDesign.Rate_limiter.limiters;

import LowLevelDesign.Rate_limiter.RateLimiter;
import LowLevelDesign.Rate_limiter.RateLimiterConfig;
import LowLevelDesign.Rate_limiter.RateLimiterType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
public class TokenBucketLimiter extends RateLimiter {

    private final Map<String, Integer> tokens = new ConcurrentHashMap<>();
    private final Map<String, Long> lastRefillTime = new HashMap<>();

    public TokenBucketLimiter(RateLimiterConfig config) {
        super(config, RateLimiterType.TOKEN_BUCKET);
    }

    @Override
    public boolean allowRequest(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis();

        tokens.compute(userId, (id, availableTokens) -> {
            int currentTokens = refillTokens(userId, now);

            if (currentTokens > 0) {
                allowed.set(true);           // mark allowed BEFORE we decrement
                return currentTokens - 1;    // consume 1 token
            } else {
                return currentTokens;        // remain at 0
            }
        });

        return allowed.get();
    }



    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    // free user refill rate = 60 / 10 = 6
    private int refillTokens(String userId, long now) {
        double refillRate = (double) config.getWindowInSeconds() / config.getMaxRequests();

        long lastRefill = lastRefillTime.getOrDefault(userId, now);
        long elapsedSeconds = (now - lastRefill) / 1000;
        int refillTokens = (int) (elapsedSeconds / refillRate);

        int currentTokens = tokens.getOrDefault(userId, config.getMaxRequests());
        currentTokens = Math.min(config.getMaxRequests(), currentTokens + refillTokens);
        if (refillTokens > 0) lastRefillTime.put(userId, now);

        return currentTokens;
    }
}

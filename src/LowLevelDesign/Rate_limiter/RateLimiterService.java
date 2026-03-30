package LowLevelDesign.Rate_limiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {

    private final Map<UserTier,RateLimiter> rateLimiterMap = new HashMap<>();

    public RateLimiterService(){

        rateLimiterMap.put(UserTier.FREE,
                RateLimiterFactory.getRateLimiter(RateLimiterType.TOKEN_BUCKET,
                        new RateLimiterConfig(10,60))); // 10 req/min

        rateLimiterMap.put(UserTier.PREMIUM,
                RateLimiterFactory.getRateLimiter(RateLimiterType.FIXED_WINDOW,
                        new RateLimiterConfig(100,60)));   // 100 req/min


    }

    public boolean allowRequest(User user){
        RateLimiter limiter = rateLimiterMap.get(user.getUserTier());

        if (limiter == null) {
            throw new IllegalArgumentException("No limiter configured for tier: " + user.getUserTier());
        }

        return limiter.allowRequest(user.getUserId());
    }

}

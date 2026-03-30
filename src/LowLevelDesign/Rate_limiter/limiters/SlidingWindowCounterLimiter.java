package LowLevelDesign.Rate_limiter.limiters;

import LowLevelDesign.Rate_limiter.RateLimiter;
import LowLevelDesign.Rate_limiter.RateLimiterConfig;
import LowLevelDesign.Rate_limiter.RateLimiterType;

public class SlidingWindowCounterLimiter extends RateLimiter {
    public SlidingWindowCounterLimiter(RateLimiterConfig config) {
        super(config, RateLimiterType.SLIDING_WINDOW_COUNTER);
    }

    @Override
    public boolean allowRequest(String userId) {
        return true;
    }
}

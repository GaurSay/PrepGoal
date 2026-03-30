package LowLevelDesign.Rate_limiter;

import LowLevelDesign.Rate_limiter.limiters.FixedWindowLimiter;
import LowLevelDesign.Rate_limiter.limiters.SlidingWindowCounterLimiter;
import LowLevelDesign.Rate_limiter.limiters.SlidingWindowLogLimiter;
import LowLevelDesign.Rate_limiter.limiters.TokenBucketLimiter;

public class RateLimiterFactory {

    public static RateLimiter getRateLimiter(RateLimiterType algo, RateLimiterConfig config){

        return switch(algo){
            case TOKEN_BUCKET -> new TokenBucketLimiter(config);
            case FIXED_WINDOW -> new FixedWindowLimiter(config);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogLimiter(config);
            case SLIDING_WINDOW_COUNTER -> new SlidingWindowCounterLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);

        };
    }
}

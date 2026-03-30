package LowLevelDesign.Rate_limiter;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class RateLimiter {

    protected final RateLimiterConfig config;
    protected final RateLimiterType type;
    public abstract boolean allowRequest(String userId);
}

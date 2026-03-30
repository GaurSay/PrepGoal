package LowLevelDesign.Rate_limiter;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RateLimiterConfig {

    int maxRequests;
    int windowInSeconds;
}

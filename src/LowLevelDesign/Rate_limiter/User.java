package LowLevelDesign.Rate_limiter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    private final String userId;
    private final UserTier userTier;
}

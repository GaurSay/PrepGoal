package LowLevelDesign.AmazonLocker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OtpInfo {
    private String otp;
    private String lockerName;
    private String slotId;
    private LocalDateTime expiryTime;

    // constructor + getters
}
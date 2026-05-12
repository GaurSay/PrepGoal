package LowLevelDesign.AmazonLocker.Strategy;

import java.util.Random;

public class NumericOtpGenerationStrategy implements OtpGenerationStrategy {

    public String generateOtp() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}

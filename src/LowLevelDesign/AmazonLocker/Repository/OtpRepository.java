package LowLevelDesign.AmazonLocker.Repository;

import LowLevelDesign.AmazonLocker.OtpInfo;

import java.util.HashMap;
import java.util.Map;

public class OtpRepository {

    private Map<String, OtpInfo> otpMap = new HashMap<>();

    public void saveOtp(OtpInfo otp) {
        otpMap.put(otp.getOtp(), otp);
    }

    public OtpInfo getOtpInfo(String otp) {
        return otpMap.get(otp);
    }

    public void deleteOtp(String otp) {
        otpMap.remove(otp);
    }
}

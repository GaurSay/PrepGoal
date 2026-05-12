package LowLevelDesign.AmazonLocker.Service;

import LowLevelDesign.AmazonLocker.OtpInfo;
import LowLevelDesign.AmazonLocker.Repository.OtpRepository;
import LowLevelDesign.AmazonLocker.Strategy.OtpGenerationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class OtpService {

    private OtpRepository otpRepo;
    private OtpGenerationStrategy strategy;
    private Duration ttl = Duration.ofMinutes(10);

    public OtpService(OtpRepository repo, OtpGenerationStrategy strategy) {
        this.otpRepo = repo;
        this.strategy = strategy;
    }

    public OtpInfo generateOtp(String lockerName, String slotId) {

        String otp = strategy.generateOtp();

        OtpInfo info = new OtpInfo(
                otp,
                lockerName,
                slotId,
                LocalDateTime.now().plus(ttl)
        );

        otpRepo.saveOtp(info);
        return info;
    }

    public String validateAndGetSlotId(String otp, String lockerName) {

        OtpInfo info = otpRepo.getOtpInfo(otp);

        if (info == null ||
                !info.getLockerName().equals(lockerName) ||
                info.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Invalid OTP");
        }

        otpRepo.deleteOtp(otp);
        return info.getSlotId();
    }
}

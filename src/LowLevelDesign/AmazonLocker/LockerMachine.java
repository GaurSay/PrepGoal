package LowLevelDesign.AmazonLocker;

import LowLevelDesign.AmazonLocker.Repository.PackageRepository;
import LowLevelDesign.AmazonLocker.Service.LockerService;
import LowLevelDesign.AmazonLocker.Service.NotificationService;
import LowLevelDesign.AmazonLocker.Service.OtpService;
import LowLevelDesign.AmazonLocker.State.IdleState;
import LowLevelDesign.AmazonLocker.State.LockerState;
import lombok.Data;

@Data
public class LockerMachine {

    private Locker locker;
    private LockerService lockerService;
    private PackageRepository packageRepo;
    private OtpService otpService;
    private NotificationService notificationService;

    private LockerState state;

    public LockerMachine(Locker locker,
                         LockerService lockerService,
                         PackageRepository packageRepo,
                         OtpService otpService,
                         NotificationService notificationService) {
        this.locker = locker;
        this.lockerService = lockerService;
        this.packageRepo = packageRepo;
        this.otpService = otpService;
        this.notificationService = notificationService;

        this.state = new IdleState(); // initial state
    }

    // Delegation to state

    public void touch() {
        state.touch(this);
    }

    public void validateCode(String code) {
        state.validateCode(this, code);
    }

    public void closeDoor(String slotId) {
        state.closeDoor(this, slotId);
    }

    public void selectCarrierEntry() {
        state.selectCarrierEntry(this);
    }

    public void selectOption(String option) {
        state.selectOption(this, option);
    }

    public LockerStatus getStatus() {
        return state.getStatus();
    }
}

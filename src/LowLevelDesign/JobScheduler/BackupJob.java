package LowLevelDesign.JobScheduler;

public class BackupJob extends Job {

    protected BackupJob(long delayMillis) {
        super(delayMillis);
    }

    @Override
    public void execute() {

    }

}
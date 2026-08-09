package LowLevelDesign.JobScheduler;

public class ReportJob extends Job {

    public ReportJob(long delayMillis) {
        super(delayMillis);
    }

    @Override
    public void execute() {

        System.out.println("Generating report...");
    }
}

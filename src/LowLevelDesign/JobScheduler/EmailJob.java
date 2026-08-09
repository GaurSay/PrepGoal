package LowLevelDesign.JobScheduler;

public class EmailJob extends Job {

    private final String email;

    public EmailJob(String email,
                    long delayMillis) {

        super(delayMillis);

        this.email = email;
    }

    @Override
    public void execute() {

        System.out.println(
                "Sending email to "
                        + email);
    }
}

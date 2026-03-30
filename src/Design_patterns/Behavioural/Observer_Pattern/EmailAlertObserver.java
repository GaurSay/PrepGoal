package Design_patterns.Behavioural.Observer_Pattern;

public class EmailAlertObserver implements NotificationAlertObserver{

    public String email;
    StockObservable observable;

    public EmailAlertObserver(String email,StockObservable observable){
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {

        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Email sent to "+ email + " successfully");
    }
}

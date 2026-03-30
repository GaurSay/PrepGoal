package Design_patterns.Behavioural.Observer_Pattern;

public class SmsAlertObserver implements NotificationAlertObserver{

    public int mobileNo;
    StockObservable observable;

    public SmsAlertObserver(int mobileNo,StockObservable observable){
        this.mobileNo = mobileNo;
        this.observable  = observable;
    }

    @Override
    public void update() {
        sendSms();
    }

    private void sendSms() {
        System.out.println("sms sent to "+ mobileNo + " successfully");
    }
}

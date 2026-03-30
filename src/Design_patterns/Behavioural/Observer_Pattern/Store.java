package Design_patterns.Behavioural.Observer_Pattern;

public class Store {

    public static void main(String[] args) {
        StockObservable iphoneObserver = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserver("shubham@gmail.com",iphoneObserver);
        NotificationAlertObserver observer2 = new SmsAlertObserver(99119911,iphoneObserver);

        iphoneObserver.add(observer1);
        iphoneObserver.add(observer2);

        iphoneObserver.setStockCount(10);
        iphoneObserver.setStockCount(20);
        iphoneObserver.setStockCount(0);
        iphoneObserver.setStockCount(30);

    }
}

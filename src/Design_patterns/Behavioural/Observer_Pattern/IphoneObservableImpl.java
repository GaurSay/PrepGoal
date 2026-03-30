package Design_patterns.Behavioural.Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    public List<NotificationAlertObserver> list = new ArrayList<>();
    public int stockCount =0;

    @Override
    public void add(NotificationAlertObserver observer) {
        list.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : list){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(newStockAdded == 0){
            stockCount =0;
            return;
        }
        System.out.println("stock count "+ stockCount);
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount += newStockAdded;
    }

    @Override
    public int getCountStock() {
        return stockCount;
    }
}

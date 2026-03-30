package Threading;

public class EvenTask implements Runnable{

    @Override
    public void run() {
        for(int i=2;i<200;i+=2){
            System.out.println(Thread.currentThread().getName()+" " +i);
        }
    }
}

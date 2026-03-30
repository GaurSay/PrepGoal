package Threading;

public class OddTask implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<200;i+=2){
            System.out.println(Thread.currentThread().getName()+" " +i);
        }
    }
}

package Concurrency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Printer implements Runnable{
    private State state;
    private int step;
    private int maxValue;
    private int currValue;
    private PrintType currPrintType;
    private PrintType nextToPrintType;

    @Override
    public void run() {
    try{
        while(currValue<=maxValue){
            synchronized (state){
                if(this.currPrintType != state.getNextToPrint()){
                    state.wait();
                }
                
                System.out.println(currPrintType.toString()+" : "+currValue);
                currValue += step;
                state.setNextToPrint(this.nextToPrintType);
                state.notifyAll();
            }
        }
    } catch(Exception e){

    }

    }
}

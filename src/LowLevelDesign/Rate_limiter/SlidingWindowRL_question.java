package LowLevelDesign.Rate_limiter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRL_question {


    private final int maxRequests;
    private final long windowMillis;
    private final Deque<Long> requestLog;

    public SlidingWindowRL_question(int maxRequests, double windowInSeconds){
        this.maxRequests = maxRequests;
        this.windowMillis = (long) (windowInSeconds * 1000);
        this.requestLog = new ArrayDeque<>();
    }
     public boolean allow(){
        long curr = System.currentTimeMillis();

        while(!requestLog.isEmpty() && requestLog.peekFirst() < curr - windowMillis){
            requestLog.pollFirst();
        }

        if(requestLog.size()<maxRequests){
            requestLog.addLast(curr);
            return true;
        }

        return false;
     }
}

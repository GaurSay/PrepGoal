package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0;i<k;i++){
            pq.add(arr[i]);
        }

        ans.add(pq.peek());


        for(int i =k;i<arr.length;i++){
            pq.remove(arr[i-k]);
            pq.add(arr[i]);
            ans.add(pq.peek());
        }

        System.out.println(ans.toString());

    }
}

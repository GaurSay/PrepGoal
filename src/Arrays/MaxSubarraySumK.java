package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySumK {

    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1};
        int K = 15;
        System.out.println(maxLen(arr,arr.length,K));
    }

    public static int maxLen(int[] arr, int n,int K) {
        int max = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum==K){
                max = Math.max(max,i+1);
            }
            if(map.containsKey(sum-K)){
                max = Math.max(max,i-map.get(sum-K));
            }
            map.putIfAbsent(sum,i);

        }
        return max;
    }
}

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayWithSum0 {

    public static void main(String[] args) {
        int arr[] = {9, -3, 3, -1, 6, -5};
        System.out.println(maxLen(arr,arr.length));
    }

    public static int maxLen(int[] arr, int n) {
        int max = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum==0){
                max = Math.max(max,i+1);
            }
            if(map.containsKey(sum)){
                max = Math.max(max,i-map.get(sum));
            } else{
                map.put(sum,i);
            }

        }
        return max;
    }
}

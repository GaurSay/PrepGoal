package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSumSubarraySizeKDistinct {

    public static void main(String[] args) {
        int arr[]= {1,5,4,2,9,9,9};
        int k =3;

        Map<Integer,Integer> map = new HashMap<>();

        int i=0;
        int sum =0;
        int maxSum = 0;

        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);

            if(j-i+1>k){
                sum-=arr[i];
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }

            if(j-i+1 == k && map.size()==k){
                maxSum = Math.max(maxSum,sum);
            }

        }

        System.out.println(maxSum);

    }
}

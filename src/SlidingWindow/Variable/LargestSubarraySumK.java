package SlidingWindow.Variable;


//Core Idea
//Expand window → increase sum
//If sum > k → shrink window
//If sum == k → update max length


import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySumK {

    public static int longestSubarray2(int[] arr, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLen = 0;

        while (j < arr.length) {

            sum += arr[j];

            // shrink if sum > k
            while (sum > k) {
                sum -= arr[i];
                i++;
            }

            // check if equal
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }

        return maxLen;
    }

    public static int longestSubarray(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // if sum == k
            if (sum == k) {
                maxLen = i + 1;
            }

            // check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // store first occurrence only
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int k = 8;
        System.out.println(longestSubarray(arr,k));
    }
}

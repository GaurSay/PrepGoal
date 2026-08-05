package SlidingWindow.Variable;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDiffIntegers {


//    A good array is an array where the number of different integers
//    in that array is exactly k. For example, [1,2,3,1,2] has
//    3 different integers: 1, 2, and 3.


//    Finding exactly K distinct directly is difficult.
//
//    Exactly(K) = AtMost(K) - AtMost(K-1)



    private static int atMost(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            freq.put(nums[right],
                    freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {

                freq.put(nums[left], freq.get(nums[left]) - 1);

                if (freq.get(nums[left]) == 0)
                    freq.remove(nums[left]);

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums ={1,2,1,2,3};
        int k = 3;
        System.out.println(atMost(nums, k) - atMost(nums, k - 1));
    }
}



package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        int max = 1;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for(int it:set){
            int x = it;
            System.out.println(" : "+ x);
            if(!set.contains(x-1)){
                int c = 1;
                while(set.contains(x+1)){
                    c++;
                    x = x+1;
                }
                max = Math.max(max,c);
            }
        }


        return max;
    }
}

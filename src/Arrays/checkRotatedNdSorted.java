package Arrays;

public class checkRotatedNdSorted {

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

    //find the disruption and see if array looks sorted already
    public boolean check(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                c++;
            }
        }
        if(nums[n-1]>nums[0]){
            c++;
        }
        return c<=1;
    }
}

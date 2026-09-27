package SlidingWindow.Variable;


//Given a binary array nums and an integer k,
//        return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//
//        Example 1:
//
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
public class MaxConsectiveOnes {

    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(arr,k));
    }

    public static int longestOnes(int[] nums, int k) {
        int i =0;
        int max = 0;
        int n = nums.length;
        int zeros =0;
        int j =0;
        while(j<n){

            if(nums[j] == 0){
                zeros++;
            }

            if(zeros <= k){
                max = Math.max(max,j-i+1);
            }

            while(zeros>k){
                if(nums[i] == 0){
                    zeros--;
                }
                i++;
            }

            j++;
        }

        return max;
    }
}

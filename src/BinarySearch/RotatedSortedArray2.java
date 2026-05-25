package BinarySearch;

public class RotatedSortedArray2 {

    //There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int k = 3;
        System.out.println(search(arr,k));
    }

    public static boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l++;
                r--;
                continue;
            }
            // left side sorted
            if(nums[l] <= nums[mid]){
                if(nums[l]<=target && nums[mid]>=target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(nums[mid]<=target && nums[r]>=target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return false;
    }
}

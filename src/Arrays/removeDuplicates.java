package Arrays;

public class removeDuplicates {

    public static void main(String[] args) {
        int arr[]={1,1,2,2,2,3,3};

        System.out.println(removeDuplicates2(arr));

    }

   // https://leetcode.com/problems/remove-duplicates-from-sorted-array/


    // 1. start from 1, check if j is not equal to i , which means unique element came ( find which is not equal to i
    // when found replace with j , increment
    // 2. put the different element in i+1 and increment


    public static int removeDuplicates2(int[] nums) {
        //2 pointer algo
        int n = nums.length;
        int i =0;
        for(int j=1;j<n;j++){
            //find diff , insert at i+1
            if(nums[j]!=nums[i]){
                nums[i+1]= nums[j];
                i++;
            }
        }

        return i;
    }
}

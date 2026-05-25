package Google;

public class NextPermutation {

    public static void main(String[] args) {
        int nums[] = {3,2,1};
        int n = nums.length;
        int i = n-2;

        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }

            //swap i and j
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums,i+1,n-1);

        for(i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();

    }

    private static void reverse(int[] nums, int l, int r) {
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}

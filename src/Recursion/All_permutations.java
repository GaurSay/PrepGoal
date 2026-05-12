package Recursion;

import java.util.ArrayList;
import java.util.List;

public class All_permutations {
    public static void main(String[] args) {
        int nums[] = {1,3,5,7};
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[n];



//        printAll(nums,nums.length,ds,freq);
        permute(nums,0);
    }

    private static void printAll(int[] nums, int n,List<Integer> ds,boolean[] freq) {

        if(ds.size() == n){
            for(int i=0;i<ds.size();i++){
                System.out.print(ds.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                printAll(nums,n,ds,freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

    static void permute(int[] nums, int index) {
        if (index == nums.length) {
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1);
            swap(nums, index, i); // backtrack
        }
    }

    static void swap(int[] nums, int a,int b) {
        int temp =  nums[a];
        nums[a] = nums[b];
        nums[b] =  temp;
    }

}

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class All_permutations {
    public static void main(String[] args) {
        int nums[] = {1,3,5,7};
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[n];



        printAll(0,nums,nums.length,ds,freq);
    }

    private static void printAll(int index, int[] nums, int n,List<Integer> ds,boolean[] freq) {

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
                printAll(i+1,nums,n,ds,freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}

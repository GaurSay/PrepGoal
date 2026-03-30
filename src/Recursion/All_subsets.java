package Recursion;

import java.util.ArrayList;
import java.util.List;

public class All_subsets {

    public static void main(String[] args) {
        int nums[] = {1,3,5};
        List<Integer> ds = new ArrayList<>();



        printAll(0,nums,nums.length,ds);
    }

    private static void printAll(int index, int[] nums, int n,List<Integer> ds) {

        if(index == n){
            for(int i=0;i<ds.size();i++){
                System.out.print(ds.get(i)+" ");
            }
            System.out.println();
            return;
        }
        //take
        ds.add(nums[index]);
        printAll(index+1,nums,n,ds);
        //not take
        ds.remove(ds.size()-1);
        printAll(index+1,nums,n,ds);
    }
}

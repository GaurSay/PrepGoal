package Dynamic_prog.LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequenceBinary {

    public static void main(String[] args) {
//        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int nums[] = {1,7,8,4,5,6,-1,9};
        int n = nums.length;


        List<Integer> temp = new ArrayList<>();

        temp.add(nums[0]);
        int len =1;
        for(int i=1;i<n;i++){
            if(nums[i] > temp.get(temp.size()-1)){
                temp.add(nums[i]);
                len++;
            }
            else{
                int index = Collections.binarySearch(temp,nums[i]);

                if(index < 0){
                    index = -(index+1);
                }
                temp.set(index,nums[i]);
            }
        }
        System.out.println(len);




    }
}

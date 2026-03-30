package BinarySearch;

import java.util.ArrayList;

public class SpecialInteger {
    /*
    Special Integer
    Problem :
    Given an array of integers A and an integer B,
    find and return the maximum value K such that there is
    no subarray in A of size K with the sum of elements greater than B.
     */

    public int solve(ArrayList<Integer> A, int B) {

        int l = 0;
        int r = A.size();
        int ans = 0;
        while(l<=r){
            int mid = (l + r) >> 1;
            long maxsum = maxsubarray(A,B,mid);
            if(maxsum <=B){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    private long maxsubarray(ArrayList<Integer> A, int B, int k){
        long maxsum = 0;
        long sum  = 0;
        for(int i=0;i<k;i++){
            sum += A.get(i);
        }
        maxsum  = Math.max(sum,maxsum);

        for(int i=k;i<A.size();i++){
            sum -= A.get(i-k);
            sum += A.get(i);
            maxsum  = Math.max(sum,maxsum);
        }
        return maxsum;
    }
}

package BinarySearch;

import java.util.ArrayList;

public class PeakElement {
    /*
        Given an array of integers A, find and return the peak element in it.
        An array element is peak if it is NOT smaller than its neighbors.

        For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
     */

    public int solve(ArrayList<Integer> A) {
        int l = 0;
        int r = A.size()-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(A.get(mid) < A.get(mid+1)){
                l = mid +1;
            }
            else{
                r = mid;
            }
        }
        return A.get(l);
    }

}

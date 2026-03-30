package BinarySearch;

import java.util.ArrayList;

public class SingleElementInSortedArray {


      /*
    Problem Description
    Given a sorted array of integers A where every element appears twice except
    for one element which appears once, find and return this single element that appears only once.
       */

    public int solve(ArrayList<Integer> A) {

        int l = 0;
        int r = A.size()-1;

        while(l<r){
            int mid = (l+r)>>1;
            if((mid%2 == 0 && A.get(mid).equals(A.get(mid+1)) )  || (mid %2 == 1 && A.get(mid).equals(A.get(mid-1))) ){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return A.get(l);
    }
}

package BinarySearch;

import java.util.List;

public class PeakElement {
    /*
        Given an array of integers A, find and return the peak element in it.
        An array element is peak if it is NOT smaller than its neighbors.

        For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
     */

    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5,6,7,8,5,1};
        System.out.println(solve(List.of(arr)));
    }

    public static int solve(List<Integer> A) {
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

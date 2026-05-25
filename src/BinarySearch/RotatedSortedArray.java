package BinarySearch;

import java.util.List;

public class RotatedSortedArray {
    /*
        Problem Description
        Given a sorted array of integers A of size N and an integer B.
        array A is rotated at some pivot unknown to you beforehand.
        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
        You are given a target value B to search. If found in the array, return its index otherwise, return -1.
     */

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,7,0,1,2};
        int k = 3;
        System.out.println(search(List.of(arr),k));
    }

    public static int search(final List<Integer> A, int B) {

        int low = 0;
        int high = A.size()-1;

        while(low <= high){
            int mid = (low+high)>>1;
            if(A.get(mid) == B){
                return mid;
            }
            //left side sorted or not
            if(A.get(low) <= A.get(mid) ){
                if(A.get(low) <= B && B<=A.get(mid)){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(A.get(mid)<=B && B<=A.get(high)){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }

}

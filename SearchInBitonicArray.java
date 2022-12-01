package BinarySearch;

import java.util.ArrayList;

public class SearchInBitonicArray {

    /*
       Given a bitonic sequence A of N distinct elements,
       write a program to find a given element B in the bitonic sequence in O(logN) time.
    Input 1:
    A = [3, 9, 10, 20, 17, 5, 1]
    B = 20
    Input 2:
    A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
    B = 30
    Example Output
    Output 1:
        3
    Output 2:
            -1
    */
    public int solve(ArrayList<Integer> A, int B) {

        if(A.size()==0){
            return 0;
        }
        int max = getmax(A);

        // search on left side
        int index = binarySearch(A,0,max,B);
        if(index !=-1){
            return index;
        }
        index = reverseBinarySearch(A,max,A.size()-1,B);
        return index;
    }

    private int reverseBinarySearch(ArrayList<Integer> A, int l, int r, int B){
        while(l<=r){
            int mid = (l+r) >> 1;
            if(A.get(mid) == B){
                return mid;
            }
            else if(A.get(mid) < B){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    private int binarySearch(ArrayList<Integer> A, int l,int r,int B){
        while(l<=r){
            int mid = (l+r) >> 1;
            if(A.get(mid) == B){
                return mid;
            }
            else if(A.get(mid) < B){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;

    }

    private int getmax(ArrayList<Integer> A){

        int low = 0;
        int high = A.size()-1;

        while(low <= high){
            int mid = (low+high)>>1;
            if(A.get(mid) > A.get(mid-1) && A.get(mid) > A.get(mid+1)){
                return mid;
            }
            else if(A.get(mid) > A.get(mid-1) && A.get(mid) < A.get(mid+1)){
                low  = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;

    }
}

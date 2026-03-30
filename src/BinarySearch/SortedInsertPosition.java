package BinarySearch;

import java.util.ArrayList;

public class SortedInsertPosition {

    /*
     Problem  :  Given a sorted array A of size N and a target value B,
            return the index (0-based indexing) if the target is found.
    If not, return the index where it would be if it were inserted in order.
*/

    public int searchInsert(ArrayList<Integer> A, int B) {

        int floor = -1;
        int low = 0;
        int high = A.size()-1;

        while(low <= high){
            int mid = (low+high)>>1;
            if(A.get(mid) == B){
                return mid;
            }
            else if(A.get(mid) < B){
                floor = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return floor +1;
    }
}

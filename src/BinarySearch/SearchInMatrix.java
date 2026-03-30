package BinarySearch;

import java.util.ArrayList;

public class SearchInMatrix {

    /*
Problem Description
Given a matrix of integers A of size N x M and an integer B.
Write an efficient algorithm that searches for integer B in matrix A.
This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
*/

    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int low = 0;
        int high = (m*n)-1;

        while(low<=high){
            int mid = (low+high)>>1;
            int row  = mid/m;
            int col = mid%m;

            if(A.get(row).get(col) == B){
                return 1;
            }
            else if(A.get(row).get(col) < B){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 0;
    }
}

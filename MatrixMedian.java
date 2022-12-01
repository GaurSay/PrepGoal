package BinarySearch;

import java.util.ArrayList;

public class MatrixMedian {
    /*
    Problem Description
    Given a matrix of integers A of size N x M in which each row is sorted.
    Find and return the overall median of matrix A.
     */

    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        int l =1;
        int h = (int)1e9;
        int n = A.size();
        int m = A.get(0).size();

        while(l<=h){
            int mid = (l+h) >> 1;
            int count = getSmaller(A,mid);
            if(count <= (n*m)/2){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return l;

    }

    private int getSmaller(ArrayList<ArrayList<Integer>> A,int x){
        int count = 0;
        for(int i=0;i<A.size();i++){
            ArrayList<Integer> row = A.get(i);
            int l =0;
            int h = row.size()-1;
            while(l<=h){
                int mid = (l+h) >> 1;
                if(row.get(mid)<=x){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            count = count + l;
        }

        return count;
    }
}

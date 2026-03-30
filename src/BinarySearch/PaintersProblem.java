package BinarySearch;

import java.util.ArrayList;

public class PaintersProblem {
    /*
        Given 2 integers A and B and an array of integers C of size N.
        Element C[i] represents the length of ith board.
        You have to paint all N boards [C0, C1, C2, C3 … CN-1].
        There are A painters available and each of them takes B units of time to paint 1 unit of the board.

        Calculate and return the minimum time required to paint all boards
        under the constraints that any painter will only paint contiguous sections of the board.
        NOTE:
    1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter,
    and partially by another.
    2. A painter will only paint contiguous boards.
    This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
    Return the ans % 10000003.
     */

    public int paint(int A, int B, ArrayList<Integer> C) {
        long l = Long.MIN_VALUE;
        long h = 0;
        long ans = 0;
        for(int i=0;i<C.size();i++){
            h += C.get(i);
            l = Math.max(l,C.get(i));
        }
        l = l*B;
        h = h*B;

        while(l<=h){
            long mid = (long) (l+h) >> 1;
            System.out.println(mid+"..."+l+"..."+h);
            if(check(A,B,C,mid)){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return (int)(ans% 10000003);
    }

    public boolean check(long A, long B, ArrayList<Integer> C,long mid){
        long painter = 1;
        long totaltime = 0;
        for(int i=0;i<C.size();i++){

            if(totaltime + (long)C.get(i)*B > mid){
                painter++;
                totaltime = (long)C.get(i)*B;
            }
            else{
                totaltime = totaltime + (long)C.get(i)*B;
            }

        }
        if(painter <= A){
            return true;
        }
        return false;
    }
}

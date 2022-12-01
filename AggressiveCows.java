package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {
    /*
    To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
    such that the minimum distance between any two of them is as large as possible.
    What is the largest minimum distance?
     */
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int l = 1;
        int r = A.get(A.size()-1) - A.get(0);
        int ans = 0;
        while(l<=r){
            int mid = (l +r) >> 1;
            // maximise if true
            if(check(A,B,mid)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    private boolean check(ArrayList<Integer> A, int B,int d){
        int cowsplaced = 1;
        int lastplaced = A.get(0);

        for(int i=1;i<A.size();i++){
            if(A.get(i)-lastplaced >= d){
                cowsplaced++;
                lastplaced = A.get(i);
            }
            if(cowsplaced == B){
                return true;
            }
        }
        return false;
    }
    
}

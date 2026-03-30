package BinarySearch;

import java.util.List;

public class KthPrice {

    /*
    Problem :  KthPrice
    Given the price list at which tickets for a flight were purchased,
    figure out the kth smallest price for the flight.
    kth smallest price is the minimum possible n such that there are at least k price elements in the price list
    with value <= n. In other words, if the price list was sorted, then A[k-1]
    ( k is 1 based, while the array is 0 based ).
    Example:
    A : [2 1 4 3 2]
    k : 3

    Answer : 2
*/

    public int kthsmallest(final List<Integer> A, int B) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<A.size();i++){
            low = Math.min(low,A.get(i));
            high = Math.max(high,A.get(i));
        }
        int ans = high;
        // System.out.println("max=" +high+" "+low);
        while(low<=high){
            int mid = (low+high) >> 1;
            int count = getcount(A,mid);
            if(count >= B){
                ans = mid ;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }

    private int getcount(final List<Integer> A,int max){
        // System.out.println("mid=" + max);
        int count  = 0;
        for(int num:A){
            if(num <= max){
                count++;
            }
        }
        // System.out.println("count=" + count);
        return count;
    }
}

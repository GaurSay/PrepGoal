package BinarySearch;

import java.util.List;

public class RotatedSortedMin {

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,7,0,1,2};
        int k = 3;
        System.out.println(search(List.of(arr),k));
        System.out.println(times(List.of(arr),k));
    }

    public static int search(final List<Integer> A, int B) {

        int low = 0;
        int high = A.size()-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low+high)>>1;
            //optimization
            if(A.get(low) <= A.get(high)){
                ans = Math.min(ans,A.get(low));
                break;
            }
            if(A.get(low) <= A.get(mid)){
                ans = Math.min(ans,A.get(low));
                low = mid+1;
            }
            else{
                ans = Math.min(ans,A.get(mid));
                high = mid-1;
            }
        }

        return ans;
    }

    // number of times array has been rotated
    public static int times(final List<Integer> A, int B) {

        int low = 0;
        int high = A.size()-1;
        int ans = Integer.MAX_VALUE;
        int index =-1;

        while(low <= high){
            int mid = (low+high)>>1;
            //optimization
            if(A.get(low) <= A.get(high)){
                if(A.get(low)<ans){
                    index = low;
                    ans = A.get(low);
                }
                break;
            }
            if(A.get(low) <= A.get(mid)){
                if(A.get(low)<ans){
                    index = low;
                    ans = A.get(low);
                }
                low = mid+1;
            }
            else{
                if(A.get(mid)<ans){
                    index = mid;
                    ans = A.get(mid);
                }
                high = mid-1;
            }
        }

        return index;
    }

}

package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {

/*
    Problem : Given a sorted array of integers A(0 based index) of size N,
    find the starting and the ending position of a given integer B in array A.
*/

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int fi = -1;
        int low = 0;
        int high = A.size() - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (A.get(mid) == B) {
                fi = mid;
                high = mid - 1;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        ans.add(fi);
        int li = -1;
        low = 0;
        high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (A.get(mid) == B) {
                li = mid;
                low = mid + 1;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        ans.add(li);
        return ans;
    }
}
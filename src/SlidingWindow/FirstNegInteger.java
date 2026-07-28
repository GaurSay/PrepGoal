package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegInteger {


    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println((firstNegative(arr, k)).toString());
        // Output: [-1, -1, -7, -15, -15, 0]
    }

    private static List<Integer> firstNegative(int[] arr, int k) {

        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;

        for (int j = 0; j < arr.length; j++) {

            // add negative number
            if (arr[j] < 0) {
                dq.offerLast(j);
            }

            // shrink if window > k
            if (j - i + 1 > k) {

                // remove expired negative
                if (!dq.isEmpty() && dq.peekFirst() == i) {
                    dq.pollFirst();
                }

                i++;
            }

            // valid window
            if (j - i + 1 == k) {

                if (!dq.isEmpty()) {
                    ans.add(arr[dq.peekFirst()]);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;
    }
}

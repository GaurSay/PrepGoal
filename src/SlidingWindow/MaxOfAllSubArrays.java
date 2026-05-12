package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubArrays {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(max(arr, k));
    }

    private static List<Integer> max(int[] arr, int k) {


        int n = arr.length;

        // Edge case
        if (n < k) {
            throw new IllegalArgumentException("Array size is smaller than k");
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        int j= 0;

        for (int i = 0; i < n; i++) {
            // Step 1: Remove out-of-window elements
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }


            // Step 2: Remove smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Step 3: Add current index
            dq.offerLast(i);

            // Step 4: Add to result
            if (i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }

        }

        return ans;

    }
}

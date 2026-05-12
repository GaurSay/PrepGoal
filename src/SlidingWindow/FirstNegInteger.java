package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FirstNegInteger {


    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println((firstNegative(arr, k)).toString());
        // Output: [-1, -1, -7, -15, -15, 0]
    }

    private static List<Integer> firstNegative(int[] arr, int k) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        int j= 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i] < 0 ){
                dq.addLast(i);
            }
            //remove outside window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            if (i >= k - 1) {
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

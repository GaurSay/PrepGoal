package SlidingWindow;

public class MaxSumSubarrayK {

    public static int maxSum(int[] arr, int k) {
        int n = arr.length;

        // Edge case
        if (n < k) {
            throw new IllegalArgumentException("Array size is smaller than k");
        }

        // Step 1: Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i];       // add next element
            windowSum -= arr[i - k];   // remove leftmost element

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSum(arr, k)); // Output: 9
    }
}

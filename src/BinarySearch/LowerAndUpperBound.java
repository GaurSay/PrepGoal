package BinarySearch;

public class LowerAndUpperBound {

    public static int lowerBound(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] >= x) {
                ans = mid;            // Store possible answer
                high = mid - 1;       // Move left
            } else {
                low = mid + 1;        // Move right
            }
        }
        return ans;  // Return the lower bound index
    }

    public static int upperBound(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1; // Store possible answer
            } else {
                high = mid - 1;
            }
        }
        return ans;  // Return the lower bound index
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};  // Sorted array
        int x = 9;
        System.out.println(arr[lowerBound(arr, x)]);
//        System.out.println(arr[upperBound(arr,x)]);
    }
}

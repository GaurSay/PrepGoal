package Arrays;

public class RotateRightByKsteps {


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int k =2;
        rotateRightByK(arr,k);
        rotateLeftByK(arr,k);
    }

    public static void print(int arr[]){
        for(int i = 0; i < arr.length;i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

    // right rotate - rotate ( 0 to n-d ) and ( n-d+1 to n )
    // 1 2 3 4 5
    // 3 2 1 5 4
    // rotate whole
    // 4 5 1 2 3
    public static void rotateRightByK(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            int index = i + k;
            if (index >= n) {
                index = index % n;
            }
            int t = nums[i];
            arr[index] = t;
        }
        print(arr);
    }


    // left rotate - rotate 0 -d  and d+1 to n
    // 1 2 3 4 5
    // 2  1 5 4 3
    // rotate whole
    // 3 4 5 1 2
    public static void rotateLeftByK(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            int index = i - k;
            if (index < 0) {
                index = index + n;
            }
            int t = nums[i];
            arr[index] = t;
        }
        print(arr);
    }

}

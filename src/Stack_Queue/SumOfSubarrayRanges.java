package Stack_Queue;

import java.util.Stack;

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] arr) {
        return sumSubarrayMaxs(arr) -  sumSubarrayMins(arr);
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007L;
        long sum = 0;

        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);

        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;

            sum = (sum + (long) arr[i] * left * right) % mod;
        }

        return sum;
    }

    public long sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        long sum = 0;

        int nse[] = findNSE(arr);
        int psee[] = findPSEE(arr);

        for(int i=0;i<arr.length;i++){
            int left = i - psee[i];
            int right = nse[i] - i;
            sum = (int) ((sum + (long) arr[i] * left * right) % mod);
        }

        return sum;

    }


    public int[] findNSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int nse[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.add(i);
        }

        return nse;

    }

    public int[] findPSEE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int psee[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.add(i);
        }

        return psee;
    }


    // Next Greater Element (strictly greater)
    public int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&
                    arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }

    public int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                    arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pgee;
    }
}

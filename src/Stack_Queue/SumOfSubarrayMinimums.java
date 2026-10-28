package Stack_Queue;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int sum = 0;

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
}

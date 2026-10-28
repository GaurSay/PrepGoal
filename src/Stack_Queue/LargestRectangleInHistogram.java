package Stack_Queue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
//        int heights[] = {2,1,5,6,2,3};
        int heights[] = {2,4};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxRect = 0 ;

        int nse[] = findNSE(heights);
        int pse[] = findPSE(heights);

        for(int i=0;i<heights.length;i++){
            maxRect = Math.max(maxRect,(nse[i]-pse[i]-1)*heights[i]);
        }

        return maxRect;
    }

    public static int[] findNSE(int[] arr) {
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

    public static int[] findPSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int pse[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.add(i);
        }

        return pse;
    }
}

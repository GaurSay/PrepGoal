package Stack_Queue;

import java.util.Stack;

public class LargestRectangleInHistogram2 {

    public static void main(String[] args) {
//        int heights[] = {2,1,5,6,2,3};
        int heights[] = {2,4};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxRect = 0;

        for(int i=0;i<heights.length;i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element =  st.pop();
                int nge = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxRect  = Math.max(maxRect,(nge - pse -1 )*heights[element]);
            }

            st.push(i);
        }

        // Process the remaining bars
        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxRect = Math.max(
                    maxRect,
                    (nse - pse - 1) * heights[element]
            );
        }


        return maxRect;


    }

}

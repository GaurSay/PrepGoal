package Stack_Queue;

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
       int arr[][] = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
       int m = arr.length;
       int n = arr[0].length;

       int presum[][] = new int[m][n];


       for(int j=0;j<n;j++){
           int sum = 0;
           for(int i=0;i<m;i++)
           {
                   sum += arr[i][j];
                   if(arr[i][j] == 0){
                       sum = 0;
                   }
                   presum[i][j] = sum;

           }

       }
//        for(int i=0;i<m;i++)
//        {
//            for(int j=0;j<n;j++){
//                System.out.print(presum[i][j]+ " ");
//            }
//            System.out.println();
//        }


        int max  = 0;

        for(int i=0;i<m;i++)
        {
            max = Math.max(max,largestRectangleArea(presum[i]));
        }

        System.out.println(max);


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

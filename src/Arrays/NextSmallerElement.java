package Arrays;

import java.util.Stack;

public class NextSmallerElement {
    // on the left
    public static void main(String[] args) {
        int arr[] = {4,5,2,10,8};
        // ans = -1 4 -1 2 2

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int n = arr.length;

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = -1;
            }
            st.add(arr[i]);
        }



        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}

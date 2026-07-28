package Arrays;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {6,0,8,1,3};

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i= arr.length-1;i>=0;i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){
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

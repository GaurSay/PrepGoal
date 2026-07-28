package Arrays;

import java.util.Stack;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        int arr[] = {2,10,12,1,11};

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int n = arr.length;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            st.add(arr[i]);
        }

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


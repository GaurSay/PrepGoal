package Stack_Queue;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                st.add(arr[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i]) ){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i]) ){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0 ){
                    st.add(arr[i]);
                }
            }
        }
        int ans[]= new int[st.size()];
        int k = st.size()-1;
        while(!st.isEmpty()){
            ans[k] = st.pop();
            k--;
        }

        return ans;
    }
}

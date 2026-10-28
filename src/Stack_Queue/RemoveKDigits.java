package Stack_Queue;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
//        String num = "1432219"; int  k = 3;
//        String num = "10200"; int  k = 1;
        String num = "01"; int  k = 2;

        Stack<Character> st = new Stack<>();

        for(Character ch : num.toCharArray()){

            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }

            if(st.isEmpty() && ch=='0'){
                continue;
            }

            st.push(ch);
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        if(sb.isEmpty()) System.out.println(0);

        System.out.println(sb.reverse());


    }
}

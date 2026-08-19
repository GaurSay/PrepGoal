package Arrays;


import java.util.Stack;

public class removeKDigits {

    public static void removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > ch) {

                stack.pop();
                k--;
            }

            if (stack.isEmpty() && ch == '0') {
                continue;
            }

            stack.push(ch);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        System.out.println(ans.toString());
    }

    public static void main(String[] args) {
       String num = "1432219";
        int k = 3;
        removeKdigits(num,k);
    }
}

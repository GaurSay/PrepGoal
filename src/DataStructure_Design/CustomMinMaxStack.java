package DataStructure_Design;

import java.util.Stack;

public class CustomMinMaxStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    Stack<Integer> maxStack;

    public CustomMinMaxStack(){
        stack= new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void insert(int element){
        stack.push(element);

        minStack.push(minStack.isEmpty() ? minStack.push(element) :
                Math.min(minStack.peek(),element));

        maxStack.push(maxStack.isEmpty() ? maxStack.push(element) :
                Math.max(maxStack.peek(),element));

    }

    public int remove(){
        int x  = stack.pop();
        minStack.pop();
        maxStack.pop();
        return x;
    }

    public int getMin(){
        return minStack.peek();
    }

    public int getMax(){
        return maxStack.peek();
    }

    public int peek(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        CustomMinMaxStack customMinMaxStack = new CustomMinMaxStack();
        customMinMaxStack.insert(5);
        customMinMaxStack.insert(2);
        customMinMaxStack.insert(8);
        customMinMaxStack.insert(1);
        customMinMaxStack.insert(7);

        System.out.println(customMinMaxStack.peek());
        System.out.println(customMinMaxStack.getMin());
        System.out.println(customMinMaxStack.getMax());
    }

}

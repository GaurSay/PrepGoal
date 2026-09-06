package DataStructure_Design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFreq_Stack {
    // 1. keep a value-freq map
    // 2. keep a map - value - freq - Stack
    // 3. keep a max freq

    Map<Integer,Integer> freqMap = new HashMap<>();
    Map<Integer, Stack<Integer>> groups = new HashMap<>();

    int maxFreq;

    public MaximumFreq_Stack(){
        maxFreq =0;
    }

    public void push(int val) {
        if(freqMap.containsKey(val)){
            int oldFreq = freqMap.get(val);
            int newFreq = oldFreq+1;
            freqMap.put(val, newFreq);
            groups.computeIfAbsent(newFreq,k-> new Stack<>()).add(val);
            maxFreq = Math.max(newFreq,maxFreq);

        }
        else{
            freqMap.put(val,1);
            groups.computeIfAbsent(1,k-> new Stack<>()).add(val);
            maxFreq = Math.max(maxFreq, 1);
        }
    }

    public int pop() {
        Stack<Integer> st = groups.get(maxFreq);
        int x = st.pop();
        freqMap.put(x, freqMap.get(x) - 1);
        if(st.isEmpty()){
            maxFreq--;
        }
        return x;
    }

    public static void main(String[] args) {
        MaximumFreq_Stack freqStack = new MaximumFreq_Stack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,5,7,5]
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}

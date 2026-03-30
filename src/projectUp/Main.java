package projectUp;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        String ans = minWindow("ADOBECODEBANC","ABC");
    }


    public static String minWindow(String s, String t) {
        int start =0;
        int e =0;
        int counter = t.length();
        String ans = "";

        Map<Character,Integer> map= new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // return map.toString();

        while(e<s.length()){
            char ch = s.charAt(e);
            if(map.containsKey(ch)){
                if(map.get(ch) >0){
                    counter--;
                }
                map.put(ch,map.get(ch)-1);
            }
            if(counter == 0){
                while(start<=e){
                    if(map.containsKey(s.charAt(start))){
                        boolean isValid = map.get(s.charAt(start))+1 <=0 ? true : false;
                        if(isValid){
                            map.put(s.charAt(start),map.get(s.charAt(start))+1);
                            start++;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        start++;
                    }
                }
                String temp = s.substring(start,e+1);
                if(ans.length()==0 || ans.length()>temp.length()){
                    System.out.println(ans+" " );
                    ans = temp;
                }
            }
            e++;
        }
        return ans;
    }
}

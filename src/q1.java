import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q1 {
    public static void main(String[] args) {
//        System.out.println("hello");
//        String s = "abdsebad";
//        String s = "abba";
//        String s = "abcba";
        String s = "tmmzuxt";

        int start = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLength = 0;
        int i =0;
        List<String> ans = new ArrayList<>();
        int ei =0;
        int si =0;
        while(i<s.length()){
            if(hm.containsKey(s.charAt(i))){
                int prevOcc = hm.get(s.charAt(i));
                start = Math.max(start,prevOcc+1);
                if((i-start) > maxLength){
                    maxLength = Math.max(maxLength,i-start);
                    si = start;
                    ei=i+1;
//                    ans.add(s.substring(start,i+1));
                }

                hm.put(s.charAt(i),i);
            }
            else{
                hm.put(s.charAt(i),i);
                if((i-start+1) > maxLength){
                    maxLength = Math.max(maxLength,i-start+1);
                    si = start;
                    ei=i+1;
//                    ans.add(s.substring(start,i+1));
                }

            }
            i++;
        }
        if((i-start) > maxLength){
            maxLength = Math.max(maxLength,i-start);
            si = start;
            ei=i;
        }

//        maxLength = Math.max(maxLength,i-start);

        System.out.println(maxLength);
          System.out.println(s.substring(si,ei));



    }
}

package Google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        String s = "abcabcbb";

        int max = 0;

        int l=0;
        int r=0;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        while(r<n){
            if(set.contains(s.charAt(r))){
                while( l<r && set.contains(s.charAt(l))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }

            set.add(s.charAt(r));
            max = Math.max(max,r-l+1);
            r++;
        }

        System.out.println(max);

    }
}

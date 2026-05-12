package SlidingWindow.Variable;

import java.util.*;

public class LongestSubstringKUnique {

    public static int longestKUnique(String s, int k) {
        int i = 0, j = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0) + 1);

            // Case 1: valid window
            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            // Case 2: too many unique chars → shrink
            while (map.size() > k) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestKUnique(s, k)); // Output: 7
    }
}

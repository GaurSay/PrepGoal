package SlidingWindow.Variable;

import java.util.*;

public class PickToys {

    public static int pickToys(String s) {
        int i = 0, j = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0) + 1);

            // shrink if more than 2 distinct chars
            while (map.size() > 2) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            // valid window
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abaccab";

        System.out.println(pickToys(s)); // Output: 4 ("acca")
    }
}

package SlidingWindow.Variable;

import java.util.Arrays;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring2(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int maxLen = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (lastSeen[c] >= i) {
                i = lastSeen[c] + 1;
            }

            lastSeen[c] = j;
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }


    public static int lengthOfLongestSubstring(String s) {

        int[] freq = new int[128]; // ASCII
        int i = 0, j = 0;
        int maxLen = 0;

        while (j < s.length()) {

            char right = s.charAt(j);
            freq[right]++;

            // if duplicate → shrink
            while (freq[right] > 1) {
                char left = s.charAt(i);
                freq[left]--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
        System.out.println(lengthOfLongestSubstring2(s)); // Output: 3
    }
}

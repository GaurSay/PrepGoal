package SlidingWindow;

import java.util.*;

public class CountAnagrams {

    public static int countAnagrams(String txt, String pat) {
        int k = pat.length();
        int n = txt.length();

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Frequency map
        for (char c : pat.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int i = 0, j = 0;
        int ans = 0;

        while (j < n) {

            // Step 2: include current char
            char right = txt.charAt(j);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) {
                    count--;
                }
            }

            // Step 3: window size < k
            if (j - i + 1 < k) {
                j++;
            }
            // Step 4: window size == k
            else if (j - i + 1 == k) {

                // check anagram
                if (count == 0) {
                    ans++;
                }

                // Step 5: remove left char
                char left = txt.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) == 1) {
                        count++;
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static int countAnagrams2(String txt, String pat) {
        int[] freq = new int[26];

        // Step 1: Build frequency
        for (char c : pat.toCharArray()) {
            freq[c - 'a']++;
        }

        int count = 0;

        // count unique characters in pattern
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        int k = pat.length();
        int i = 0, j = 0, ans = 0;

        while (j < txt.length()) {

            // Step 2: include right char
            char right = txt.charAt(j);
            int idxR = right - 'a';

            freq[idxR]--;

            if (freq[idxR] == 0) {
                count--;
            }

            // Step 3: window size < k
            if (j - i + 1 < k) {
                j++;
            }
            // Step 4: window size == k
            else if (j - i + 1 == k) {

                if (count == 0) {
                    ans++;
                }

                // Step 5: remove left char
                char left = txt.charAt(i);
                int idxL = left - 'a';

                freq[idxL]++;

                if (freq[idxL] == 1) {
                    count++;
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(countAnagrams(txt, pat)); // Output: 3
    }
}

package SlidingWindow;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t)); // Output: "BANC"
    }

    private static String minWindow(String s, String t) {

        int count = t.length();
        int[] freq = new int[128];
        int n = s.length();


        // Step 1: build frequency
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }

        int i = 0;
        int j = 0;
        int min_length = Integer.MAX_VALUE;
        int start = 0;

        while(j<n){
            // Step 2: include right char
            char right = s.charAt(j);

            if(freq[right]>0){
                count--;
            }
            freq[right]--;
            j++;

            // Step 3: shrink window when valid -> //reduce size
            while(count == 0){

                if(j-i < min_length){
                    min_length = j-i;
                    start = i;
                }

                char left = s.charAt(i);
                freq[left]++;

                if (freq[left] > 0) {
                    count++;
                }

                i++;
            }
        }

        return min_length == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + min_length);

    }
}

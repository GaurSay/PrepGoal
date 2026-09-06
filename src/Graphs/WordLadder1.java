package Graphs;

import java.util.*;

public class WordLadder1 {

    public static void main(String[] args) {
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit"; String endWord = "cog";

        System.out.println(findMinPath(arr,beginWord,endWord));
    }

    private static int findMinPath(String[] arr, String beginWord, String endWord) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        Set<String> set = new HashSet<>();
        Collections.addAll(set, arr);
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().key;
            int steps = q.peek().val;
            q.poll();

            if(word.equals(endWord)){
                return steps;
            }
            // find replaced words
            for(int i=0;i<word.length();i++){
                for(char ch ='a';ch<='z';ch++){
                    char replacedWordChar[] = word.toCharArray();
                    replacedWordChar[i]=ch;
                    String replacedWord = new String(replacedWordChar);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;

    }

    static class Pair{
        public String key;
        public Integer val;

        public Pair(String key,Integer val){
            this.key= key;
            this.val=val;
        }
    }
}

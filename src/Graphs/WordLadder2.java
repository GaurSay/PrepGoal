package Graphs;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit"; String endWord = "cog";

        findMinPath2(arr,beginWord,endWord);
    }

    private static void findMinPath2(String[] arr, String beginWord, String endWord) {

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        Collections.addAll(set, arr);
        ArrayList<String> usedOnlevel = new ArrayList<>();
        usedOnlevel.add(beginWord);
        int level =0;

        while(!q.isEmpty()){
            ArrayList<String> vec = q.poll();

            if(vec.size() > level){
                level++;
                for(String it : usedOnlevel){
                    set.remove(it);
                }
            }

            String word = vec.get(vec.size()-1);
            if(word.equals(endWord)){
                if(ans.isEmpty()){
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }else if (vec.size() > ans.get(0).size()) {
                    break;
                }
            }

            for(int i=0;i<word.length();i++){
                for(char ch ='a';ch<='z';ch++){
                    char replacedWordChar[] = word.toCharArray();
                    replacedWordChar[i]=ch;
                    String replacedWord = new String(replacedWordChar);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);

                        usedOnlevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }


        }


        for(int i=0;i<ans.size();i++){
            for(String s : ans.get(i)){
                System.out.print(s+" ");
            }
            System.out.println();
        }


    }
}

package Arrays;

import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class trial2 {

//Question1: Word wrapper:
//
//
//Input:
//
//words1 = [ "The", "day", "began", "as", "still", "as", "the",
//
//          "night", "abruptly", "lighted", "with", "brilliant",
//
//          "flame" ]

//Wrapped Word length should not be more than 13.

//Output:
//
//wrapLines(words1, 13) ... "wrap words1 to line length 13" =>

//  [ "The-day-began", The-day-began-as
//
//    "as-still-as",
//
//    "the-night",
//
//    "abruptly",
//
//    "lighted-with",
//
//    "brilliant",
//
//    "flame" ]
    public static void main(String[] args) throws Exception {
       String words1[] = { "The", "day", "began", "as", "still", "as", "the",

          "night", "abruptly", "lighted", "with", "brilliant",

          "flame"};
        int length = 13;
        ArrayList<String> wordList =  wrapLines(words1, length);
        for(String s : wordList){
            System.out.println(s);
        }


    }

    private static ArrayList<String> wrapLines(String[] words1, int length) throws Exception {
        ArrayList<String> ansList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<words1.length;i++){
            if(words1[i].length()>length){
                throw new Exception("Incorrect Exception");
            }
            sb.append(words1[i]);
            if(i<words1.length-1){
                if(words1[i+1].length()+sb.length()+1<=length){
                    sb.append("-");
                }
                else{
                    ansList.add(sb.toString());
                    sb = new StringBuilder();
                }
            }

        }
        return ansList;
    }
}

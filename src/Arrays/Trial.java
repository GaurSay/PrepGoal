package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Trial {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(6,5,4,3,2,1));
                                                                // 1 2 3 4 5 6
        ArrayList<Integer> arr = new ArrayList<>(numbers);
        Collections.sort(arr);
        int first = 0;
        int last = arr.size();
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i) != arr.get(i)){
                first = i;
                break;
            }
        }

        for(int i=numbers.size()-1;i>=0;i--){
            if(numbers.get(i) != arr.get(i)){
                last = i;
                break;
            }
        }
        System.out.println(last-first+1);




    }
}

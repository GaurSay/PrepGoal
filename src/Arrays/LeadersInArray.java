package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};

        int n = arr.length;


        // Last element of the array is always a leader
        int max = arr[arr.length - 1];

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[n-1]);


        for(int i=n-2;i>=0;i--){

            if(arr[i]>max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(ans);
        System.out.println(ans.toString());
    }
}

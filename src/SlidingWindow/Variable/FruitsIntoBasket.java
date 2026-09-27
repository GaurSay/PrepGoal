package SlidingWindow.Variable;

import java.util.HashMap;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int fruits[] = {1, 2, 3, 2, 2};
        totalFruits(fruits);
    }


    public static void totalFruits(int[] fruits) {
       int n = fruits.length;

       int i=0;
       int j=0;

        int k=2;

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        while(j<n){

            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            while(map.size()>2){
                int left = fruits[i];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                i++;
            }

            max = Math.max(max,j-i+1);
            j++;
        }

        System.out.println(max);
    }
}

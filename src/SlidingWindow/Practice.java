package SlidingWindow;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        int arr[]={2, 1, 5, 1, 3, 2};
        //1. max Sum in SubArray of K size
//        maxSuminSubArrayKsize();

        //2. Max Element in subarray K size
//        maxOfAllSubarray();

        //3. First Negative Integer
//        firstNegativeInteger();

        //4. Max Points from Cards
//        maxPointsFromCards();

        // 5. count anagrams
//        countAnagrams();

       // 6. Max Sum Subarray size k distinct
        maxSumSubarrayKsizeDistinct();
    }

    private static void maxSumSubarrayKsizeDistinct() {

        int arr[]= {1,5,4,2,9,9,9};
        int k =3;
        int i =0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        int maxSum =0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);

            if(j-i+1>k){
                sum-=arr[i];
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }

            if(j-i+1 == k && map.size()==k){
                maxSum = Math.max(maxSum,sum);
            }



        }
        System.out.println(maxSum);
    }

    private static void countAnagrams() {

        String txt = "forxxorfxdofr";
        String pat = "for";

        int k = pat.length();

        Map<Character,Integer> map = new HashMap<>();

        for (char c : pat.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i =0;
        int count =map.size();
        int ans = 0;
        for(int j=0;j<txt.length();j++){
            char right = txt.charAt(j);
            if(map.containsKey(right)){
                map.put(right,map.get(right)-1);
                if(map.get(right) == 0 ){
                    count--;
                }
            }

            if(j-i+1 == k){
                if(count ==0){
                    ans++;
                }
                char left = txt.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left) == 1){
                        count++;
                    }
                }
                i++;
            }
        }

        System.out.println(ans);
    }

    private static void maxPointsFromCards() {
        int arr[] = {6,2,3,4,7,2,1,7,1};
        int k =4;

        int n = arr.length;
        int lsum =0;
        int rsum =0;
        int rindex = n-1;

        //calculated whole left window sum
        for(int i=0;i<k;i++){
            lsum+= arr[i];
        }

        int maxSum =lsum;
        for(int i=k-1;i>=0;i--){
            lsum -= arr[i];
            rsum += arr[rindex];
            rindex--;
            maxSum = Math.max(maxSum,lsum+rsum);
        }

        System.out.println(maxSum);
    }

    private static void firstNegativeInteger() {

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int i =0;
        List<Integer> ans = new ArrayList<>();
        for(int j=0;j<arr.length;j++){
            if(arr[j]<0){
                deque.offer(j);
            }

            if(j>=k-1) {
                ans.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);

                if (!deque.isEmpty() && deque.peekFirst() == i) {
                    deque.pollFirst();
                }

                i++;
            }
        }

        System.out.println(ans.toString());




    }

    private static void maxOfAllSubarray() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.removeLast();
            }

            deque.offer(i);

            if(i>=k-1){
                ans.add(arr[deque.peekFirst()]);
            }
        }

        System.out.println(ans.toString());
    }

    private static void maxSuminSubArrayKsize() {

        int arr[]={2, 1, 5, 1, 3, 2};
        int k =3;

        int windowSum =0;
        int maxSum = 0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }

        maxSum = windowSum;
        for(int i=k;i<arr.length;i++){
            windowSum+=arr[i];
            windowSum-=arr[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        System.out.println(maxSum);
    }
}

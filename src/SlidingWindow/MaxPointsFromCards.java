package SlidingWindow;

public class MaxPointsFromCards {

    public static void main(String[] args) {
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
}

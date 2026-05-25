package Google;

public class productExceptSelf {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        int temp =1;

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = temp;
            temp =  temp * arr[i];
        }

        temp =1 ;

        for(int i=n-1;i>=0;i--){
            ans[i] = temp * ans[i];
            temp =  temp * arr[i];
        }

        for(int i=0;i<n;i++){
            System.out.print(ans[i] + " ");
        }




    }


}

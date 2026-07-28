package Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        int n = arr.length;
        // find first 0
        int j =-1;
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                j =i;
                break;
            }
        }
        if(j==-1){
            return ;
        }

        for(int i= j+1;i<n;i++) {
            // if non zero  = swap
            if (arr[i] != 0) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
        }
        print(arr);
    }

    public static void print(int arr[]){
        for(int i = 0; i < arr.length;i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}

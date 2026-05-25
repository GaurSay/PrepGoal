package Google;

public class trapping_rainwater {

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        int l= 0;
        int r= arr.length-1;

        int lmax = 0;
        int rmax = 0;
        int sum = 0;


        while(l<=r){
            if(arr[l]<=arr[r]){
                if(arr[l] >= lmax){
                    lmax = arr[l];
                } else{
                    sum+= lmax - arr[l];
                }
                l++;
            } else{
                if(arr[r] >= rmax){
                    rmax = arr[r];
                } else{
                    sum+= rmax - arr[r];
                }
                r--;
            }
        }

        System.out.println(sum);
    }
}

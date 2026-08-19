package BinarySearch;

public class MinimumdaystoMakeMBouquets {

    public static void main(String[] args) {
        int arr[] = {7,7,7,7,13,11,12,7};
        int m =2;
        int k =3;
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }

        int l = min;
        int h = max;
        int ans = 0;
        if(arr.length < m*k){
            System.out.println(-1);
        }
        while(l<=h){
            int mid = (l+h) >>1;
            if(possible(arr,mid,m,k)){
                ans = mid;
                h= mid-1;
            }else{
                l = mid+1;
            }
        }

        System.out.println(ans +" "+l);
    }


    public static boolean possible(int arr[],int day,int m,int k){
        int count =0;
        int b=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }else{
                b += count/k;
                count =0;
            }
        }
        b += count/k;
        return b >= m;

    }
}

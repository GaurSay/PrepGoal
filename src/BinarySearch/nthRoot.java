package BinarySearch;

public class nthRoot {

    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(Math.round(helper(m,n)));
    }

    private static double helper(double m,int n){
        double low =1;
        double high= m;
        double eps = 1e-7;
        while(high-low>eps){
            double mid = (low+high)/2.0;
            if(multiply(mid,n) < m){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    private static double multiply(double x,int n){
        double ans=1.0;
        while(n>0){
            ans*=x;
            n--;
        }
        return ans;
    }


}

package BinarySearch;

public class AthMagicalNo {

    /*
    Problem : You are given three positive integers, A, B, and C.
    Any positive integer is magical if divisible by either B or C.
    Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
*/

    public int solve(int A, int B, int C) {
        int mod = 1000000007;
        long l = 1;
        long r = (long)Math.min(B,C) * A;
        long ans = 1;
        while(l<=r){
            long mid = (l+r) >> 1;
            long c = getcount(B,C,mid);
            if(c >= A){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return (int)(ans%1000000007);
    }

    private long getcount(int B,int C,long mid){
        long b = mid/B;
        long c = mid/C;
        long bc = mid/getLcm(B,C);
        // System.out.println(b +" -" + c +"-" + bc);
        long t = b + c - bc;
        // System.out.println("count"+ t);
        return t;
    }

    private int getLcm(int B,int C){
        long lcm=(long) B*C/gcd(B,C);
        // System.out.println(lcm);
        return (int)lcm;
    }
    private int gcd(int x,int y){
        if(x == 0) return y;

        return gcd(y%x,x);
    }
}

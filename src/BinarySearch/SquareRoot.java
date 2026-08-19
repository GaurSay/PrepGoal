package BinarySearch;

public class SquareRoot {

/*
    Problem Description
    Given an integer A.
    Compute and return the square root of A.
    If A is not a perfect square, return floor(sqrt(A)).

 */

    public static void main(String[] args) {
        System.out.println(sqrt(16));
    }
    public static int sqrt(int A) {
        long l = 0;
        long h = A;
        long ans =0;
        int e = 10^-2;
        while(h-l>=e){
            long mid = (l+h) >> 1;
            if(mid*mid == A){
//                System.out.println(mid);
                return (int)mid;
            }
            if(mid*mid <=A){
                ans = mid;
                l = mid;
            }
            else{
                h = mid;
            }
        }
        System.out.println(l);
        return (int) (ans%1000000007);
    }
}

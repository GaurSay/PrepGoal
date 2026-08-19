package BinarySearch;

import java.util.List;

public class AllocateBooks {
     /*
        Given an array of integers A of size N and an integer B.
        The College library has N books. The ith book has A[i] number of pages.
        You have to allocate books to B number of students so that the maximum number
        of pages allocated to a student is minimum.
        A book will be allocated to exactly one student.
        Each student has to be allocated at least one book.
        Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

        Calculate and return that minimum possible number.
        NOTE: Return -1 if a valid assignment is not possible.
        A = [12, 34, 67, 90]   , B = 2
        Example Output : 113
     */

    public static void main(String[] args) {
        List<Integer> list = List.of(12, 34, 67, 90);
        int B = 2;
        System.out.println(books(list,B));
    }

    public static int books(List<Integer> C, int B) {
        if(B > C.size()){
            return -1;
        }
        int l = Integer.MIN_VALUE;
        int h = 0;
        int ans = 0;
        for(int i=0;i<C.size();i++){
            h += C.get(i);
            l = Math.max(l,C.get(i));
        }
        while(l<=h){
            int mid = (l+h) >> 1;
            if(check(C,B,mid)){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;

    }

    public static boolean check(List<Integer> C, int B, int page){
        int students = 1;
        long totalpages = 0;
        for(int i=0;i<C.size();i++){
            if(totalpages + C.get(i) > page){
                students++;
                totalpages = C.get(i);
            }
            else{
                totalpages += C.get(i);
            }
        }
        if(students <= B){
            return true;
        }
        return false;
    }
}

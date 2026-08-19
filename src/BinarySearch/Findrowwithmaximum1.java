package BinarySearch;

public class Findrowwithmaximum1 {

    public static void main(String[] args) {
        int arr[][]= {{0, 0, 1},{1, 1, 1},{0, 0, 0}};

        System.out.println(rowWithMax1s(arr));
    }

    public static int rowWithMax1s(int[][] mat) {
        int i =0;
        int j = mat[0].length-1;
        int maxRow = -1;
        boolean found = false;
        while(i<mat.length && j>=0){
            if(mat[i][j] ==1){
                found = true;
                maxRow =i;
                j--;
            } else{
                i++;
            }
        }
        return found ? maxRow: -1;

    }
}

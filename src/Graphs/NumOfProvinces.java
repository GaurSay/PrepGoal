package Graphs;

public class NumOfProvinces {

    public static void main(String[] args) {
        int arr [][] = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }

    public static int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        int vis[] = new int[l];
        int count = 0;

        for(int i = 0;i<l;i++) {
            if(vis[i] == 0) {
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    public static void dfs(int i, int[][] M, int[] visited) {
        for (int j = 0; j < M.length; j++) {
//            System.out.println(i +" "+j);
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                System.out.println("going for dfs recursion : " +i +" "+j);
                dfs(j,M, visited);
//                System.out.println("completed ");
            }
        }
    }
}

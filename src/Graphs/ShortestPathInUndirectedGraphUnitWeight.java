package Graphs;

import java.util.*;

public class ShortestPathInUndirectedGraphUnitWeight {

    public static int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[0]=0;
        q.add(0);


        while(!q.isEmpty()){
            int curr = q.poll();

            for(int n: adjList.get(curr)){
                if(dist[curr] +1 < dist[n]){
                    dist[n] = 1+ dist[curr];
                    q.add(n);
                }
            }
        }

        for(int i=0;i<N;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }


        return dist;

    }

    public static void main(String[] args) {
       int  n = 9; int m = 10;
       int[][] edges = {{0,1},{0,3},{3,4},{4,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
       //0 1 2 1 2 3 3 4 4
       int ans[] = shortestPath(edges,n,m);
        System.out.println(Arrays.toString(ans));
    }

    static class Pair {
    int val;
    int w;
        Pair(int val, int w) {
            this.val = val;
            this.w = w;
        }
    }
}

package Graphs;

import java.util.*;

public class ShortedPathInDAG {

    public static int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair(v,w));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        dist[0]=0;
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
           Pair curr = q.poll();

            for(Pair n: adjList.get(curr.val)){
                if(dist[curr.val] + n.w < dist[n.val]){
                    dist[n.val] = n.w + dist[curr.val];
//                    System.out.println(" ----- " + n.val +" "+ dist[n.val]);
                    q.add(new Pair(n.val, dist[n.val]));
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
        int  n = 6; int m = 7;
        int[][] edges = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        // 0 2 3 6 1 5
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

package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithinKStop {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int flight[] : flights) {
            int i = flight[0];
            int j = flight[1];
            int d = flight[2];
            adjList.get(i).add(new Pair(n, j, d));
        }
        Queue<Pair> q = new LinkedList<>();
        int distance[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        q.add(new Pair(0, src, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int sr = curr.sr;
            int currDist = curr.dist;
            int stops = curr.k;


            //run until full complete
//            if(sr== dst){
//
//            }
            if (stops > k) continue;

            for (Pair neigh : adjList.get(sr)) {
                int adjNode = neigh.sr;
                int edgeDist = neigh.dist;
                if (currDist + edgeDist < distance[adjNode]) {
                    distance[adjNode] = currDist + edgeDist;
                    q.add(new Pair(stops + 1, adjNode, distance[adjNode]));
                }
            }
        }
        if (distance[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return distance[dst];
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));

    }

    static class Pair {
        int sr;
        int k;
        int dist;

        public Pair(int k, int sr, int dist) {
            this.sr = sr;
            this.k = k;
            this.dist = dist;
        }
    }
}

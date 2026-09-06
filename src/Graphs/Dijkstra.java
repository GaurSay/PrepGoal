package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {





    }


    public static void shortestPath(){

        List<List<Pair>> adjList = new ArrayList<>();
        int N = 5;
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int currDist = curr.distance;

            for (Pair neighbor : adjList.get(node)) {

                int nextNode = neighbor.node;
                int weight = neighbor.distance;

                if (currDist + weight < dist[nextNode]) {

                    dist[nextNode] = currDist + weight;

                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
    }

    static class Pair{
        int node;
        int distance;


        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}

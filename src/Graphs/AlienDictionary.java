package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    public static void main(String[] args) {
        String words[]={"baa", "abcd", "abca", "cab", "cad"};
        int n = words.length;
        int K = 4;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int p=0;p<len;p++){
                if(s1.charAt(p)!=s2.charAt(p)){
                    // Add edge s1[ptr] -> s2[ptr]
                    adj.get(s1.charAt(p)-'a').add(s2.charAt(p)-'a');
                    break;
                }
            }
        }

        // Perform topological sort
        List<Integer> topo = topoSort(K, adj);


        // Convert numeric representation back to characters
        StringBuilder ans = new StringBuilder();
        for (int node : topo) {
            ans.append((char)(node + 'a'));
        }

        System.out.println(ans.toString());
    }

    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {

        // Array to keep track of indegree (number of incoming edges) of each node
        int[] indegree = new int[V];

        // Calculate indegree for each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }


        // Queue to store nodes with indegree = 0 (i.e., nodes that can be processed first)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        // List to store topological order
        List<Integer> topo = new ArrayList<>();


        // Process the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node); // Add node to result

            // Decrease indegree of its neighbors
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return topo;

    }
}

package Graphs;

import java.util.*;

public class CreateGraph {

    private static ArrayList<ArrayList<Integer>> list = null;

    public static void main(String[] args) {
        // v - vertex

        int v = 5;
        list = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            list.add(i, new ArrayList<>());
        }
        HashMap<Integer,Integer> hm;
        // Adding edges one by one
        addEdge(list, 0, 1);
        addEdge(list, 0, 4);
        addEdge(list, 1, 2);
        addEdge(list, 1, 3);
        addEdge(list, 1, 4);
        addEdge(list, 2, 3);
        addEdge(list, 3, 4);

        // print graph
//		printGraph(list);

//		int distance = BFS (0,2);
//		System.out.println("min distance is " + distance);

//		DFS(0);

//		System.out.println(DFSPathExist(0,3,5));
//		System.out.println(dfsStack(0,3));
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(" -> " + list.get(i).get(j));
            }
            System.out.println();
        }
    }


    private static int BFS(int source, int dest) {
        boolean visited[] = new boolean[list.size()];

        int parent[] = new int[list.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr+" ");
//			if (curr == dest)
//				break;

            for (int neighbor : list.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = curr;
                }
            }
        }
        int curr = dest;
        int distance = 0;

//		while (parent[curr] != -1) {
//			System.out.print(curr + " -> ");
//			curr = parent[curr];
//			distance++;
//		}
//		System.out.print(source);
//		System.out.println();
        return distance;

    }


    /////// Traverse Graph with DFS /////////
    static void DFS(int v) {
        boolean visited[] = new boolean[list.size()];
        DFSUtil(v, visited);

        // loop over visited to check if any node is false
    }

    static void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        List<Integer> neighbor = list.get(v);
        for (int n : neighbor) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }

    }

    //// DFS Path exist between source and destination ////////
    static boolean DFSPathExist(int s,int d,int v) {
        boolean visited[] = new boolean[v];
        visited[s] = true;

        return DFS_PAth_util(s,d,visited);
    }

    static boolean DFS_PAth_util(int s,int d,boolean visited[]) {
        if(s==d) return true;

        for(int n : list.get(s)) {
            if(!visited[n]) {
                visited[n] = true;
                boolean isConnected = DFS_PAth_util(n,d,visited);
                if(isConnected) return true;
            }
        }
        return false;
    }


    ///// dfsStack iteratively //////////////
    public static boolean dfsStack(int source, int destination) {
        boolean visited[] = new boolean[list.size()];
        visited[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while(!stack.isEmpty()) {
            int curr = stack.pop();

            if(curr == destination) return true;

            for(int neighbor: list.get(curr)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }


}

package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class detectCycleUndirectedgraph {

    boolean detect(int src, List<List<Integer>> adjList, int vis[]){
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));

        while(!q.isEmpty()){
            int s = q.peek().src;
            int parent = q.peek().parent;
            q.remove();

            for(int n : adjList.get(s)){
                if(vis[n] == 0){
                    vis[n] = 1;
                    q.add(new Pair(n,s));
                }else if(parent != n){
                    return true;
                }
            }
        }
        return false;

    }
}
class Pair{
    public Pair(int src, int parent) {
        this.src = src;
        this.parent = parent;
    }

    int src;
    int parent;

}
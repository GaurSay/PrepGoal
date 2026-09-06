package DataStructure_Design;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    Node head = new Node(-1,-1);
    Node tail  = new Node(-1,-1);

    private final int capacity;

    Map<Integer,Node> map = new HashMap<>();

    public LRU(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int k,int v){
        if(map.containsKey(k)){
            Node n = map.get(k);
            remove(n);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }

        insert(new Node(k,v));
    }

    public int get(int k){
        if(map.containsKey(k)){
            Node n = map.get(k);
            remove(n);
            insert(n);
            return n.val;
        }
        return -1;
    }

    private void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insert(Node n){
        map.put(n.key,n);
        n.next = head.next;
        head.next = n;
        n.prev = head;
        n.next.prev = n;
    }
    static class Node{
        Node prev,next;
        int val,key;

        Node(int k,int v){
            this.key = k;
            this.val = v;
        }
    }
}



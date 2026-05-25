package Google;

import java.util.HashMap;
import java.util.Map;

public class LRU_CACHE {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map;
    int capacity;


    public LRU_CACHE(int capacity){
        this.capacity= capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }else{
            return -1;
        }

    }

    private void insert(Node node) {
        map.put(node.key,node);
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }


}

class Node{
    Node prev,next;
    int val,key;

    Node(int k,int v){
        this.key = k;
        this.val = v;
    }
}

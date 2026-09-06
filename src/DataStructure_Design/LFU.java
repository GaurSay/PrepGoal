package DataStructure_Design;

import java.util.HashMap;
import java.util.Map;

public class LFU {

    private int minFreq;

    Map<Integer,DoublyLinkedList> freqMap = new HashMap<>();

    Map<Integer,Node> keyMap = new HashMap<>();

    private final int capacity;

    public LFU(int capacity){
        this.capacity = capacity;
        this.minFreq = 0;

    }

    public int get(int key){
        if(keyMap.containsKey(key)){
            Node n = keyMap.get(key);
            updateFrequency(n);
            return n.value;
        }
        return -1;
    }
    private void updateFrequency(Node node){
        int freq = node.freq;
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.remove(node);

        if(freq == minFreq && oldList.isEmpty()){
            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(node.freq,k-> new DoublyLinkedList()).addFirst(node);
    }

    public void put(int key,int val){
        if (capacity == 0) {
            return;
        }
        // Key already exists
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = val;

            updateFrequency(node);
            return;
        }

        // capacity full
        if(capacity == keyMap.size()){
            //get lowest freq map
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node toRemove = minFreqList.removeLast();

            keyMap.remove(toRemove.key);
        }

        Node newNode = new Node(key,val);

        keyMap.put(key,newNode);

        freqMap.computeIfAbsent(1,
                        k -> new DoublyLinkedList())
                .addFirst(newNode);
        // New nodes always have frequency 1
        minFreq =1;
    }


    static class DoublyLinkedList{
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;

            nextNode.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if(size == 0){
                return null;
            }

            Node n = tail.prev;
            remove(n);
            return n;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    static class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

}

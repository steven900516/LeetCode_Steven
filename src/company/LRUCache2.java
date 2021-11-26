package company;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2021-11-26
 */
public class LRUCache2 {
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache2(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }


    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        //map包含key
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            Node x = new Node(key,value);
            cache.addLast(x);
            map.put(key,x);
            return;
        }
        //超出容量
        if(cap == cache.capcity){
            Node node = cache.removeFirst();
            map.remove(node.key);
        }

        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);

    }

}
class Node{
    int key;
    int value;
    Node pre,next;

    public Node(int key,int val){
        this.key = key;
        this.value = val;
    }
}

class DoubleList{
    Node head,tail;
    int capcity;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        capcity = 0;
    }

    public void addLast(Node last){
        last.pre = tail.pre;
        tail.pre.next = last;
        last.next = tail;
        tail.pre = last;
        capcity++;
    }

    public void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        capcity--;
    }



    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }


    public int size(){
        return capcity;
    }



}
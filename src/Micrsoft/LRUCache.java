package Micrsoft;

import java.util.HashMap;

/**
 * @author Steven0516
 * @create 2022-02-05
 */
class LRUCache {

    private HashMap<Integer, CNode> map;

    private DoubleList cache;

    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }


    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        CNode x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        //map包含key
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            CNode x = new CNode(key,value);
            cache.addLast(x);
            map.put(key,x);
            return;
        }
        //超出容量
        if(cap == cache.capcity){
            CNode node = cache.removeFirst();
            map.remove(node.key);
        }

        CNode x = new CNode(key, value);
        cache.addLast(x);
        map.put(key, x);

    }
}

class CNode{
    int key;
    int value;
    CNode pre,next;

    public CNode(int key,int val){
        this.key = key;
        this.value = val;
    }
}

class DoubleList{
    CNode head,tail;
    int capcity;

    public DoubleList(){
        head = new CNode(0,0);
        tail = new CNode(0,0);
        head.next = tail;
        tail.pre = head;
        capcity = 0;
    }

    public void addLast(CNode last){
        last.pre = tail.pre;
        tail.pre.next = last;
        last.next = tail;
        tail.pre = last;
        capcity++;
    }

    public void remove(CNode x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        capcity--;
    }



    public CNode removeFirst(){
        if(head.next == tail){
            return null;
        }
        CNode first = head.next;
        // head.next = head.next.next;
        // head.next.next.pre = head;
        remove(first);
        return first;
    }


    public int size(){
        return capcity;
    }



}

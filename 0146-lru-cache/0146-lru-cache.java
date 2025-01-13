import java.util.ArrayList;
import java.util.List;

class Node{
    int key,value;
    Node prev,next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev=null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer,Node> map = new HashMap<>();
    int capacity;

    Node head = new Node(-1,-1); // dummy node
    Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public void deleteNode(Node curr){

        Node nextCurr = curr.next;
        Node prevCurr = curr.prev;

        prevCurr.next=nextCurr;
        nextCurr.prev = prevCurr;
    }

    public void insertAfterHead(Node curr){

        Node nextHead = head.next;

        curr.next = nextHead;
        curr.prev = head;

        head.next = curr;
        nextHead.prev = curr;
    }
    
    public int get(int key) {

        if(map.containsKey(key)){
            Node curr = map.get(key);
            deleteNode(curr);
            insertAfterHead(curr);
            
            return curr.value;
        }else{
            return -1;
        }


        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value; // updating the new value
            deleteNode(curr); // delete and now pushing to front of head
            insertAfterHead(curr);
        }else{
            // multiple condition, if its full, delete and then push
            if(map.size()==capacity){
                // remove the lfu, which is near to tail
                Node curr = tail.prev;
                deleteNode(curr);
                map.remove(curr.key); // delete from map as well
            }

            // coming from first time
            Node curr = new Node(key,value);
            insertAfterHead(curr);
            map.put(key,curr); // update in map
            
        }
        
    }
}

/* using brute force, using list
class LRUCache {

    List<int[]> cache; // Stores key-value pairs
    int capacity;

    public LRUCache(int capacity) {
        cache = new ArrayList<>(capacity); // Initialize the cache
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            int[] entry = cache.get(i);
            if (entry[0] == key) {
                // Move the accessed entry to the most recently used position
                cache.remove(i);
                cache.add(entry);
                return entry[1]; // Return the value
            }
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        // Check if the key already exists in the cache
        for (int i = 0; i < cache.size(); i++) {
            int[] entry = cache.get(i);
            if (entry[0] == key) {
                // Update the value and move the entry to the most recently used position
                cache.remove(i);
                cache.add(new int[]{key, value});
                return;
            }
        }

        // If the cache is at full capacity, remove the least recently used entry
        if (cache.size() == capacity) {
            cache.remove(0);
        }

        // Add the new entry to the most recently used position
        cache.add(new int[]{key, value});
    }
}
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */

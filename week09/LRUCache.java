import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName:  LRUCache
 * @Description: 146. LRU 缓存机制
 * @link: https://leetcode-cn.com/problems/lru-cache/
 * @author: liuezhong
 * @date:   2021/9/30 下午10:47
*/

public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){};
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private int size;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void addToHead(Node node) {
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
    }
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}

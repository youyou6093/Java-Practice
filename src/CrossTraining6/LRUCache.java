package CrossTraining6;
import java.util.*;


public class LRUCache<K, V> {
    static class Node<K, V> {
        V val;
        K key;
        Node prev;
        Node next;
        Node(K key, V val) {
            this.val = val;
            this.key = key;
        }
    };

    HashMap<K, Node<K,V>> m = new HashMap<>();
    Node<K, V> head;
    Node<K, V> tail;
    int cap;
    int size;

    public LRUCache(int limit) {
        cap = limit;
        size = 0;
    }

    public void set(K key, V value) {
        remove(key);
        insert(key, value);
        if (size > cap) {
            remove(head.key);
        }
    }

    public V get(K key) {
        if (!m.containsKey(key)) {
            return null;
        }
        V val = m.get(key).val;
        remove(key);
        insert(key, val);
        return val;
    }

    public void remove(K key) {
        if (!m.containsKey(key)) return;
        Node<K, V> node = m.get(key);
        m.remove(key);
        //remove
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (node == tail) {
            if (node.prev != null) {
                tail = node.prev;
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        size--;
    }

    public void insert(K key, V val) {
        Node node = new Node(key, val);
        m.put(key, node);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
}

package uber_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a LRUImpl cache, for an insert into cache operation, remove the last element in cache
 */

class DQueue {
    DQueue prev = null;
    DQueue next = null;
    int key;
    String value;

    DQueue(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUImpl {
    public static void main(String[] args) {
        LRU cache = new LRU(4);
        try {
            cache.get(1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Element `1` not found in cache");
        }
        cache.put(1, "one");
        cache.put(2, "two");

        // Display the cache, should be 2, 1
        System.out.println("Cache display results::");
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();

        // Try to get existing element
        System.out.println("Get cache value for 1: " + cache.get(1));
        // Above operation should reshuffle the cache as well, the new cache should have 1, 2
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();

        cache.put(3, "three");
        cache.put(4, "four");
        cache.put(5, "five");

        // Display the cache, should be decreasing order of insert, `one` shouldnt be present as limit of 4 was reached
        // The result should be 5, 4, 3, 1
        System.out.println("Cache display results::");
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();

        // Try to access 2 should throw an exception
        try {
            System.out.println("Cache value of 2:: " + cache.get(2));
        } catch (IllegalArgumentException ex) {
            System.out.println("Element `2` not found in cache");
        }

        // Try to access 3
        System.out.println("Get cache value for 3: " + cache.get(3));
        // Display the cache, should be decreasing order of insert, `one` shouldnt be present as limit of 4 was reached
        // The result should be 3, 5, 4, 1
        System.out.println("Cache display results::");
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();


        // Try to find if 1 exists
        System.out.println("1 exists?? : "+ cache.hasElement(1));
        // The result should be 1, 3, 5, 4
        System.out.println("Cache display results::");
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();


        // Try to find if 5 exists
        System.out.println("5 exists?? : "+ cache.hasElement(5));
        // The result should be 5, 1, 3, 4
        System.out.println("Cache display results::");
        cache.displayElements().forEach(ele -> System.out.print(ele + " "));
        System.out.println();
    }
}

class LRU {
    private DQueue head;
    private Map<Integer, DQueue> map;
    private DQueue tail;

    private int capacity;
    private int count = 0;

    LRU(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    boolean hasElement(int key) {
        if(map.containsKey(key)) {
            String value = remove(key);
            addToHead(key, value);
            return true;
        }
        return false;
    }

    String get(int key) {
        // gets the element if present/throw an exception, regardless, insert the accessed the value in the first of order
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Element does not exist");
        }
        String value = map.get(key).value;
        remove(key);
        addToHead(key, value);
        return value;
    }

    void put(int key, String value) {
        if (count == capacity) {
            removeLast();
        }
        addToHead(key, value);

        // if the cache has reached its limit, remove the last element, regardless at the end, insert the element at first of its order
    }

    private void addToHead(int key, String value) {
        if (!hasElement(key)) {
            if (count == capacity) {
                remove(tail.key);
            }
            DQueue temp = new DQueue(key, value);
            if (count == 0) {
                head = temp;
                head.next = tail;
                tail = head;
                tail.prev = head;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            map.put(key, temp);
            count++;
        }
    }

    private void removeLast() {
        remove(tail.key);
    }

    private String remove(int key) {
        DQueue value = map.get(key);
        if (value.next != null) {
            value.prev.next = value.next;
            value.next.prev = value.prev;
        } else {
            value.prev.next = null;
            tail = value.prev;
        }
        map.remove(key);
        count--;
        return value.value;
    }

    List<String> displayElements() {
        DQueue temp = head;
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < count; i++, temp = temp.next)
            tempList.add(temp.value);
        return tempList;
    }
}

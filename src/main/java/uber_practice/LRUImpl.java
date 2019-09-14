package uber_practice;

import java.util.HashMap;

public class LRUImpl {
    static class DoublyLinkList {
        int key;
        String value;
        DoublyLinkList prev = null;
        DoublyLinkList next = null;

        public DoublyLinkList(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {
        private DoublyLinkList tail = null;

        private DoublyLinkList cacheList = null;

        private HashMap<Integer, DoublyLinkList> hashMap = new HashMap<>();

        void put(int key, String value) {
            if(hashMap.containsKey(key)) {
                moveToFront(key);
            } else {
                addElement(key, value);
            }
        }

        private void moveToFront(int key) {
            DoublyLinkList node = hashMap.get(key);
            if(node.prev != null) {
                node.prev.next = node.next;
                if (node.next != null)
                    node.next.prev = node.prev;
                node.next = cacheList;
                cacheList.prev = node;
                node.prev = null;
                cacheList = node;
            }
        }

        private void addElement(int key, String value) {
            DoublyLinkList newNode = new DoublyLinkList(key, value);
            hashMap.put(key, newNode);
            if(cacheList == null) {
                cacheList = newNode;
                tail = cacheList;
            } else {
                cacheList.prev = newNode;
                newNode.next = cacheList;
                cacheList = newNode;
            }
        }

        public String get(int key) {
            moveToFront(key);
            return hashMap.get(key).value;
        }

        public void remove(int key) {
            if(hashMap.containsKey(key)) {
                DoublyLinkList removedNode = hashMap.remove(key);
                // If only node
                if(removedNode.prev == null && removedNode.next == null) {
                    removedNode = null;
                    cacheList = null;
                } // if head
                else if(removedNode.prev == null) {
                    cacheList = cacheList.next;
                    cacheList.prev = null;
                    removedNode = null;
                } // if tail
                else if(removedNode.next == null) {
                    removedNode.prev.next = null;
                    removedNode = null;
                } else {
                    removedNode.prev.next = removedNode.next;
                    removedNode.next.prev = removedNode.prev;
                    removedNode = null;
                }
            }
        }

        void printCache() {
            DoublyLinkList temp = cacheList;
            while(temp != null) {
                System.out.print(temp.key+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();

        for(int i = 0; i < 2; i ++) {
            lruCache.put(1, "One");
            lruCache.put(2, "two");
            lruCache.put(3, "three");
            lruCache.put(4, "four");
            lruCache.put(5, "five");
            // Cache should contain sequence 5,4,3,2,1
            lruCache.printCache();

            lruCache.put(3, "three");
            // Cache should contain sequence 3,5,4,2,1
            lruCache.printCache();

            System.out.println(lruCache.get(1)); // print "ONE"
            // Cache should contain sequence 1,3,5,4,2
            lruCache.printCache();

            lruCache.remove(4);
            // Cache should contain sequence 1,3,5,2
            lruCache.printCache();

            lruCache.remove(3);
            // Cache should contain sequence 1,5,2
            lruCache.printCache();

            lruCache.put(1, "One");
            // Cache should contain sequence 1,5,2
            lruCache.printCache();

            lruCache.put(5, "Five");
            // Cache should contain sequence 5,1,2
            lruCache.printCache();

            lruCache.remove(2);
            // Cache should contain sequence 5,1
            lruCache.printCache();

            lruCache.get(1);
            // Cache should contain sequence 1,5
            lruCache.printCache();

            lruCache.remove(1);
            // Cache should contain sequence 5
            lruCache.printCache();

            lruCache.remove(5);
            // Cache should contain empty
            lruCache.printCache();

            System.out.println("-------------");
        }
    }
}

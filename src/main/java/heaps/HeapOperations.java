package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class HeapOperations {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(9, false);

        minHeap.addToHeap(15);
        minHeap.addToHeap(3);
        minHeap.addToHeap(20);
        minHeap.addToHeap(13);
        minHeap.addToHeap(4);
        minHeap.addToHeap(7);
        minHeap.addToHeap(9);
        minHeap.addToHeap(10);
        minHeap.addToHeap(8);

        int size = minHeap.size;
        // 3 4 7 8 9 10 13 15 20 
        for (int i = 0; i < size; i++) {
            System.out.print(minHeap.remove() + " ");

        }
        System.out.println();
        System.out.println();
        // for third largest
        MinHeap minHeap2 = new MinHeap(4, true);
        minHeap2.addToHeap(15);
        minHeap2.addToHeap(3);
        minHeap2.addToHeap(20);
        minHeap2.addToHeap(13);
        minHeap2.addToHeap(4);
        minHeap2.addToHeap(7);
        minHeap2.addToHeap(9);
        minHeap2.addToHeap(10);
        minHeap2.addToHeap(8);

        // Expected 13
        System.out.println(minHeap2.remove());

        System.out.println();
        System.out.println();

        PriorityQueue<Integer> minHeap3 = new PriorityQueue<>(Comparator.reverseOrder());
        add(15, minHeap3);
        add(3, minHeap3);
        add(20, minHeap3);
        add(13, minHeap3);
        add(4, minHeap3);
        add(7, minHeap3);
        add(9, minHeap3);
        add(10, minHeap3);
        add(8, minHeap3);

        // Will get 7 as third smallest, 3 set at add method
        System.out.println(minHeap3.peek());
    }

    private static void add(int aa, PriorityQueue<Integer> qq) {
        qq.add(aa);
        if (qq.size() > 3) {
            qq.poll();
        }
    }
}

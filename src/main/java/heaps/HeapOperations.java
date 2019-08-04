package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class HeapOperations {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

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
        for (int i = 0; i < size; i++) {
            System.out.println(minHeap.remove());

        }
        System.out.println();
        System.out.println();
        GrowingMaxHeap maxHeap = new GrowingMaxHeap();
        maxHeap.addToHeap(15);
        maxHeap.addToHeap(3);
        maxHeap.addToHeap(20);
        maxHeap.addToHeap(13);
        maxHeap.addToHeap(4);
        maxHeap.addToHeap(7);
        maxHeap.addToHeap(9);
        maxHeap.addToHeap(10);
        maxHeap.addToHeap(8);

        System.out.println(maxHeap.remove());

        System.out.println();
        System.out.println();

        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>(Comparator.reverseOrder());
        add(15, minHeap2);
        add(3, minHeap2);
        add(20, minHeap2);
        add(13, minHeap2);
        add(4, minHeap2);
        add(7, minHeap2);
        add(9, minHeap2);
        add(10, minHeap2);
        add(8, minHeap2);

        System.out.println(minHeap2.peek());
    }

    private static void add(int aa, PriorityQueue<Integer> qq) {
        qq.add(aa);
        if (qq.size() > 3) {
            qq.poll();
        }
    }
}

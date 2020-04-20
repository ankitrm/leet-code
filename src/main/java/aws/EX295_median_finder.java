package aws;

import java.util.Comparator;
import java.util.PriorityQueue;

// Ref: https://leetcode.com/problems/find-median-from-data-stream/
public class EX295_median_finder {
  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(70);
    medianFinder.addNum(4);
    medianFinder.addNum(15);
    medianFinder.addNum(13);
    medianFinder.addNum(14);
    medianFinder.addNum(7);
    medianFinder.addNum(11);
    medianFinder.addNum(12);
    medianFinder.addNum(9);
    medianFinder.addNum(6);
    // 4, 6, 7, 9, 11, 12, 13, 14, 15, 70
    System.out.println(medianFinder.findMedian());
  }
}

class MedianFinder {
  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;

  /**
   * initialize your data structure here.
   */
  MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  void addNum(int num) {
    minHeap.offer(num);
    maxHeap.offer(minHeap.poll());

    if (minHeap.size() < maxHeap.size()) {
      minHeap.offer(maxHeap.poll());
    }
  }

  double findMedian() {
    if (minHeap.size() > maxHeap.size()) {
      return minHeap.peek();
    } else {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
  }
}
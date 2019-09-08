package heaps;

class MinHeap {
    int[] heap = null;
    private int capacity;
    private boolean isGrowing;

    MinHeap(int capacity, boolean isGrowing) {
        this.capacity = capacity;
        heap = new int[capacity];
        this.isGrowing = isGrowing;
    }

    int size;

    private int getLeftIdx(int rootIdx) {
        return 2 * rootIdx + 1;
    }

    private int getRightIdx(int rootIdx) {
        return 2 * rootIdx + 2;
    }

    private boolean hasLeft(int rootIdx) {
        return getLeftIdx(rootIdx) < size;
    }

    private boolean hasRight(int rootIdx) {
        return getRightIdx(rootIdx) < size;
    }

    private int getLeftEle(int rootIdx) {
        return heap[getLeftIdx(rootIdx)];
    }

    private int getRightEle(int rootIdx) {
        return heap[getRightIdx(rootIdx)];
    }

    private boolean hasCapacity() {
        return size < capacity;
    }

    private int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private boolean hasParent(int childIdx) {
        return childIdx - 1 >= 0;
    }

    private int getParent(int childIdx) {
        return heap[getParentIdx(childIdx)];
    }

    void addToHeap(int ele) {
        if (hasCapacity()) {
            heap[size] = ele;
            heapifyUp(ele, size);
            size++;
        } else if (!isGrowing) {
            throw new IllegalArgumentException("Maximum capacity reached");
        }

        if (isGrowing && size > capacity - 1) {
            remove();
        }


    }

    private void heapifyUp(int ele, int idx) {
        while (hasParent(idx) && heap[idx] < getParent(idx)) {
            int parentIdx = getParentIdx(idx);
            swap(idx, parentIdx);
            idx = parentIdx;
        }
    }

    public int remove() {
        if (size > 0) {
            int ele = heap[0];
            swap(0, size - 1);
            size--;
            heapifyDown(0);
            return ele;
        } else {
            throw new IllegalArgumentException("No more elements in heap");
        }
    }

    private void heapifyDown(int idx) {
        while (hasLeft(idx)) {
            int smallerIdx = getLeftIdx(idx);
            if (hasRight(idx) && heap[smallerIdx] > getRightEle(idx)) {
                smallerIdx = getRightIdx(idx);
            }
            if (heap[idx] > heap[smallerIdx]) {
                swap(idx, smallerIdx);
                idx = smallerIdx;
            } else {
                break;
            }
        }
    }

    private void swap(int idx, int parentIdx) {
        int temp = heap[idx];
        heap[idx] = heap[parentIdx];
        heap[parentIdx] = temp;
    }
}
package heaps;

/**
 * // TODO Comment
 */
class MinHeap {

    private int capacity = 10;
    int size = 0;
    private int[] arr = new int[capacity];

    private int getLeftIndex(int parent) {
        return 2 * parent + 1;
    }

    private int getRightIndex(int parent) {
        return 2 * parent + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeft(int parent) {
        return getLeftIndex(parent) < size;
    }

    private boolean hasRight(int parent) {
        return getRightIndex(parent) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int left(int parent) {
        return arr[getLeftIndex(parent)];
    }

    private int right(int parent) {
        return arr[getRightIndex(parent)];
    }

    private int parent(int childIndex) {
        return arr[getParentIndex(childIndex)];
    }

    private boolean hasCapacity() {
        return size < capacity;
    }

    void addToHeap(int ele) {
        if (hasCapacity()) {
            arr[size] = ele;
            heapifyUp(size);
            size++;
        } else {
            throw new OutOfMemoryError();
        }
    }

    private void heapifyUp(int childIndex) {
        while (hasParent(childIndex) && parent(childIndex) > arr[childIndex]) {
            swap(arr, getParentIndex(childIndex), childIndex);
            childIndex = getParentIndex(childIndex);
        }
    }

    private void swap(int[] arr, int parentIndex, int childIndex) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[childIndex];
        arr[childIndex] = temp;
    }

    int remove() {
        int ele = arr[0];
        size--;
        swap(arr, 0, size);

        heapifyDown(0);

        return ele;
    }

    private void heapifyDown(int index) {
        while (hasRight(index) && hasLeft(index) && (arr[index] > left(index) || arr[index] > right(index))) {
            if (left(index) > right(index)) {
                swap(arr, getRightIndex(index), index);
                index = getRightIndex(index);
            } else {
                swap(arr, getLeftIndex(index), index);
                index = getLeftIndex(index);
            }
        }

        while (hasRight(index) && arr[index] > right(index)) {
            swap(arr, getRightIndex(index), index);
            index = getRightIndex(index);
        }

        while (hasLeft(index) && arr[index] > left(index)) {
            swap(arr, getLeftIndex(index), index);
            index = getLeftIndex(index);
        }
    }
}

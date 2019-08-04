package trees;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 7, 8, 10, 12, 16, 18, 22, 26, 19};

        System.out.println(binarySearch(input, 7));
    }

    private static int binarySearch(int[] input, int ele) {
        int low = 0;
        int high = input.length - 1;

        return bSearch(low, high, input, ele);
    }

    private static int bSearch(int low, int high, int[] input, int ele) {
        int mid = (low + high)/2;

        if(input[mid] == ele) {
            return mid;
        } else if(input[mid] > ele) {
            return bSearch(low, mid-1, input, ele);
        }
        else {
            return bSearch(mid+1, high, input, ele);
        }
    }
}

package trees;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 7, 8, 10, 12, 16, 18, 19, 22, 26};

        System.out.println(bSearch(input, 3));
    }

    private static int bSearch(int[] input, int ele) {
        int low = 0, high = input.length;
        while(low <= high) {
            int mid = (low + high)/2;
            if(input[mid] == ele) {
                return mid;
            }
            if(input[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}

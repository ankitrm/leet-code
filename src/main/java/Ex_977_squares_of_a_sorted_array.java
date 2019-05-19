import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
 */
public class Ex_977_squares_of_a_sorted_array {
    public static void main(String[] args) {
        Arrays.stream(sortedSquares(new int[]{-4})).forEach(System.out::println);
    }
    private static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int pointerToFirstPositive = -1;
        for(int i=0; i < A.length; i++) {
            if(A[i] >= 0) {
                pointerToFirstPositive = i;
                break;
            }
        }
        int k = 0;
        int negativeIdx = pointerToFirstPositive == -1? 0: pointerToFirstPositive-1, positiveIdx = pointerToFirstPositive;
        while(negativeIdx >=0 && negativeIdx < A.length && positiveIdx >= 0 && positiveIdx <A.length) {
            int negativeEle = Math.abs(A[negativeIdx]);

            if(negativeEle > A[positiveIdx]) {
                result[k++] = A[positiveIdx] * A[positiveIdx];
                positiveIdx++;
            } else {
                result[k++] = A[negativeIdx] * A[negativeIdx];
                negativeIdx--;
            }
        }

        while(positiveIdx >= 0 && positiveIdx <A.length) {
            result[k++] = A[positiveIdx] * A[positiveIdx];
            positiveIdx++;
        }

        while(negativeIdx >=0 && negativeIdx < A.length) {
            result[k++] = A[negativeIdx] * A[negativeIdx];
            negativeIdx--;
        }
        return result;
    }
}

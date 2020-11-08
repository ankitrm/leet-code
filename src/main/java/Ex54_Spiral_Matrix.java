import java.util.List;

/**
 * // https://leetcode.com/problems/spiral-matrix/
 */
public class Ex54_Spiral_Matrix {
    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrder(arr);
        // Display an array in spiral form counting from 0
        sprialMatrix(5);
    }

    private static void sprialMatrix(int length) {
        int i1 = 0, i2 = length - 1, j1 = 0, j2 = length - 1;
        int[][] arr = new int[length][length];
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = 0;
            }
        }
        int count = 0;
        System.out.println();
        while (i1 <= i2 && j1 <= j2) {
           // System.out.println("i1:" +i1 + " i2:" + i2 + " j1:" + j1 + " j2:" + j2);

            for(int x = j1; x <= j2; x++) {
                //System.out.print("a["+i1+"]["+x+"]="+count + " ");
                arr[i1][x] = count;
                count = count + 1;
                //System.out.print(i1+""+x + " ");
            }
            for(int x = i1 + 1; x <= i2; x++) {
                //System.out.print("a["+x+"]["+j2+"]="+count + " ");
                arr[x][j2] = count;
                count = count + 1;
                //System.out.print(x+""+j2+ " ");
            }
            for(int x = j2-1; x >= j1; x--) {
                //System.out.print("a["+i2+"]["+x+"]="+count + " ");
                arr[i2][x] = count;
                count = count + 1;
                //System.out.print(i2+""+x+ " ");
            }
            for(int x = i2 - 1; x >= i1 + 1; x--) {
                //System.out.print("a["+x+"]["+j1+"]="+count + " ");

                arr[x][j1] = count;
                count = count + 1;
                //System.out.print(x+""+j2+ " ");
            }
            i1 ++;
            i2--;
            j1++;
            j2--;
        }
        System.out.println();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void spiralOrder(int[][] arr) {
        int i1=0, i2=arr.length, j1=0, j2=arr[0].length;
        while(i1 < i2 && j1 < j2) {
            printL2R(arr, i1, j1, j2 - 1);
            printU2D(arr, j2 - 1, i1, i2 - 1);
            printR2L(arr, i2 - 1, j2 - 1, j1 +1);
            printD2U(arr, j1, i2 - 1, i1 + 1);
            i1++;
            i2--;
            j1++;
            j2--;
        }
    }

    private static void printD2U(int[][] arr, int j, int i2, int i1) {
        for(int x = i2; x >= i1; x--) {
            System.out.print(arr[x][j] + " ");
        }
    }

    private static void printU2D(int[][] arr, int j, int i1, int i2) {
        for(int x = i1; x < i2; x++) {
            System.out.print(arr[x][j] + " ");
        }
    }

    private static void printL2R(int[][] arr, int i, int j1, int j2) {
        for(int x = j1; x < j2; x++) {
            System.out.print(arr[i][x] + " ");
        }
    }

    private static void printR2L(int[][] arr, int i, int j2, int j1) {
        for(int x = j2; x >= j1; x--) {
            System.out.print(arr[i][x] + " ");
        }
    }
}

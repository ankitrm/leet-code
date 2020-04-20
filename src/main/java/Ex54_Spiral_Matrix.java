import java.util.List;

/**
 * // https://leetcode.com/problems/spiral-matrix/
 */
public class Ex54_Spiral_Matrix {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrder(arr);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        int x1 = 0, y1 = 0, x2 = matrix.length - 1, y2 = matrix[0].length - 1;

        while(x1 <= x2 && y1 <= y2) {
            displayXLR(matrix, x1, y1, y2);
            displayYTD(matrix, y2, x1 + 1, x2);
            displayXRL(matrix, x2, y2 - 1, y1);
            displayYDT(matrix, y1, x2 - 1, x1 + 1);
            x1 = x1 + 1;
            x2 = x2-1;
            y1 = y1 + 1;
            y2 = y2 - 1;
        }
        return null;
    }

    private static void displayYDT(int[][] matrix, int y2, int x1, int x2) {
        for(int i = x1; i >= x2; i--) {
            System.out.print(matrix[i][y2] + " ");
        }
    }

    private static void displayXRL(int[][] matrix, int newX, int y1, int y2) {
        for(int i = y1; i >= y2; i--) {
            System.out.print(matrix[newX][i] + " ");
        }
    }

    private static void displayYTD(int[][] matrix, int newY, int x1, int x2) {
        for(int i = x1; i <= x2; i++) {
            System.out.print(matrix[i][newY] + " ");
        }
    }

    private static void displayXLR(int[][] matrix, int x1, int y1, int y2) {
        for(int i = y1; i <= y2; i++) {
            System.out.print(matrix[x1][i] + " ");
        }
    }

}

/**
 * https://leetcode.com/problems/maximal-square
 */
public class Ex221_Maximal_Square {
  public static void main(String[] args) {
    char[][] ch = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    System.out.println(maximalSquare(ch));
  }
  private static int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    if(row == 0) {
      return 0;
    }
    int column = matrix[0].length;
    int[][] tempArr = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < row; i++) {
      tempArr[i][0] = matrix[i][0] - '0';
    }
    for(int j = 0; j < column; j++) {
      tempArr[0][j] = matrix[0][j] - '0';
    }

    for(int i = 1; i < row; i++) {
      for(int j = 1; j < column; j++) {
        if(matrix[i][j] == '1') {
          tempArr[i][j] = Math.min(tempArr[i-1][j-1], Math.min(tempArr[i-1][j], tempArr[i][j-1])) + 1;
        } else {
          tempArr[i][j] = 0;
        }
      }
    }

    int max = 0;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < column; j++) {
        if(max < tempArr[i][j]) {
          max = tempArr[i][j];
        }
      }
    }
    return max*max;
  }
}

package aws.cloudfront;

public class CloudFront {
  public static void main(String[] args) {
    int[][] arr = new int[][] {
        {0, 1, 1, 0, 1},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 0, 1},
        {0, 1, 0, 0, 0}
    };

    System.out.println(numberOfRotations(4, 5, arr));
  }

  private static int numberOfRotations(int row, int col, int[][] arr) {
    if (areAll(arr, row, col, 0)) {
      return -1;
    }
    return numberOfRotationsForConversion(row, col, arr, 0);
  }

  private static int numberOfRotationsForConversion(int row, int col, int[][] arr, int count) {
    if (areAll(arr, row, col, 1)) {
      return count;
    }
    int[][] newArr = createNew(arr, row, col);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == 0) {
          if (i + 1 < row && arr[i + 1][j] == 1) {
            newArr[i][j] = 1;
            continue;
          }

          if (i - 1 >= 0 && arr[i - 1][j] == 1) {
            newArr[i][j] = 1;
            continue;
          }

          if (j + 1 < col && arr[i][j + 1] == 1) {
            newArr[i][j] = 1;
            continue;
          }

          if (j - 1 >= 0 && arr[i][j - 1] == 1) {
            newArr[i][j] = 1;
          }
        }
      }
    }
    return numberOfRotationsForConversion(row, col, newArr, count + 1);
  }

  private static int[][] createNew(int[][] arr, int row, int col) {
    int[][] newArr = new int[row][col];
    for (int i = 0; i < row; i++) {
      if (col >= 0) System.arraycopy(arr[i], 0, newArr[i], 0, col);
    }
    return newArr;
  }

  private static boolean areAll(int[][] arr, int row, int col, int target) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] != target) {
          return false;
        }
      }
    }
    return true;
  }
}

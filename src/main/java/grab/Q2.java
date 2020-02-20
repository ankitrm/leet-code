package grab;

public class Q2 {
  static int[] solution(int[] A, int[] B) {
    int i = 0;
    int carry = 0;
    int length = A.length > B.length ? A.length : B.length;
    int[] result = new int[length];
    for (i = 0; i < A.length && i < B.length; i++) {
      int[] res = add(A[i], B[i], carry, i%2);
      result[i] = res[1];
      carry = res[0];
    }
    if(i < A.length) {
      for (i = 0; i < A.length; i++) {
        int[] res = add(A[i],0, carry, i%2);
        result[i] = res[1];
        carry = res[0];
      }
    }
    if(i < B.length) {
      for (i = 0; i < B.length; i++) {
        int[] res = add(0,B[i], carry, i%2);
        result[i] = res[1];
        carry = res[0];
      }
    }
    return result;
  }

  public static int[] add(int a, int b, int carry, int idx) {
    int result = a + b;
    if (result == 3) {
      return new int[] {1, 1};
    } else if (result == 2) {
      return new int[] {1, 0};
    } else if (result == 1) {
      return new int[] {0, 1};
    } else if (result == 0) {
      return new int[] {0, 0};
    } else if (result == -1) {
      return new int[] {-1, 0};
    }
    throw new IllegalArgumentException("hello");
  }

  public static void main(String[] args) {
    // 0,1,0,1,1,0,0,0,1,0,1,1,1
    // 0 1 0 1 1 0 0 0 1 0 1 1 1 0 0
    int[] solution2 = solution(new int[] {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1}, new int[] {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1});

    int[] solution = solution(new int[] {1, 0, 0, 1, 1, 1}, new int[] {0, 0, 1, 0, 1, 1});

    System.out.println(solution2);

  }
}

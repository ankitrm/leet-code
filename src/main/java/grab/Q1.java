package grab;

public class Q1 {
  public static void main(String[] args) {

    System.out.println(solution(new int[]{6, 4, -1, 3, 2}));
    }
  public static int solution(int[] A) {
    int inputLength = A.length;
    int size = 1;
    int i = 0;
    while(i < inputLength && i != A[i] && A[i] != -1) {
      i = A[i];
      size++;
    }
    return size;
  }
}

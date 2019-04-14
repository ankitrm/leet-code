public class Ex7_ReverseInt {
  public static void main(String[] args) {
    System.out.println(reverse(-121));
  }

  private static int reverse(int x) {
    int reverse = 0;

    while (x != 0) {
      int remainder = x % 10;
      x = x / 10;
      if (reverse == Integer.MAX_VALUE / 10 && remainder > 7 || reverse > Integer.MAX_VALUE / 10) {
        return 0;
      }
      if (reverse == Integer.MIN_VALUE / 10 && remainder < -8 || reverse < Integer.MIN_VALUE / 10) {
        return 0;
      }
      reverse = reverse * 10 + remainder;
    }
    return reverse;
  }
}

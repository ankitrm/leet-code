public class Ex9_Palindrome_Number {
  public static void main(String[] args) {
    System.out.println(isPalindrome(1000000001));
  }

  private static boolean isPalindrome(int x) {
    if(x < 0) {
      return false;
    }
    int reverse = 0;
    int tempX = x;
    while (tempX != 0) {
      int rem = tempX % 10;
      if (reverse == Integer.MAX_VALUE / 10 && rem > 7 || reverse > Integer.MAX_VALUE / 10) {
        return false;
      }
      reverse = reverse * 10 + rem;
      tempX = tempX / 10;
    }
    return reverse == x;
  }
}

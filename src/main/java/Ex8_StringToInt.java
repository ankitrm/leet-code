public class Ex8_StringToInt {
  public static void main(String[] args) {
    System.out.println(atoi("4193  sdsa  adas"));
  }

  private static int atoi(String str) {
    int number = 0;
    str = str.trim();
    boolean isNegative = false;
    if(str.startsWith("-")) {
      isNegative = true;
    }
    if(str.startsWith("+") || isNegative) {
      str = str.substring(1);
    }
    for (char ch : str.toCharArray()) {
      if(Character.isDigit(ch)) {
        int nextCh = isNegative ? -1 * (ch - '0') : ch - '0';
        if ((number == Integer.MAX_VALUE / 10) && nextCh > 7 || number > Integer.MAX_VALUE / 10) {
          return Integer.MAX_VALUE;
        } else if ((number <= Integer.MIN_VALUE / 10) && nextCh < -8 || number < Integer.MIN_VALUE / 10) {
          return Integer.MIN_VALUE;
        }
        number = number * 10 + nextCh;
      } else {
        return number;
      }
    }
    return number;
  }
}

package shopee;

import java.util.Scanner;

public class LongestDnaFinder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int length = in.nextInt();
    int k = in.nextInt();
    System.out.println();
    in.nextLine();
    String dna = in.nextLine().trim();
    System.out.println(longestDna(length, k, dna));
  }

  private static int longestDna(int length, int k, String dna) {
    char[] ch = dna.toCharArray();
    int[] res = new int[ch.length];
    int j = 0;
    char prev = 'T';
    int temp = k;
    for (char ch1 : ch) {
      if (temp >= 0) {
        if (ch1 == 'A' && prev == 'T') {
          temp--;
          res[j]++;
        } else if (ch1 == 'C' && prev == 'A') {
          res[j]++;
        } else if (ch1 == 'G' && prev == 'C') {
          res[j]++;
        } else if (ch1 == 'T' && prev == 'G') {
          res[j]++;
        }
      } else {
        j++;
        temp = k;
      }
      prev = ch1;
    }

    int max = 0;
    for (int re : res) {
      if (re > max) {
        max = re;
      }
    }
    return max;
  }
}

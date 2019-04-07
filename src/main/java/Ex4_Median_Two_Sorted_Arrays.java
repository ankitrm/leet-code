// Ref: https://leetcode.com/problems/median-of-two-sorted-arrays/

public class Ex4_Median_Two_Sorted_Arrays {

  public static void main(String[] args) {
    int[] num1 = {1,3};
    int[] num2 = {2};
    System.out.println(findMedianSortedArrays(num1, num2));
  }

  private static double findMedianSortedArrays(int[] num1, int[] num2) {
    int[] tempArray = new int[num1.length+num2.length];
    int i = 0, j = 0, k = 0;
    while(i < num1.length && j < num2.length) {
      if(num1[i] <= num2[j]) {
        tempArray[k] = num1[i];
        i++;
      } else {
        tempArray[k] = num2[j];
        j++;
      }
      k++;
    }
    while(i < num1.length)     {
      tempArray[k] = num1[i];
      i++;
      k++;
    }
    while(j < num2.length)     {
      tempArray[k] = num2[j];
      j++;
      k++;
    }
    return k%2 == 0 ? (double)(tempArray[k/2-1] + tempArray[k/2]) / 2 : (double)tempArray[k/2];
  }

}

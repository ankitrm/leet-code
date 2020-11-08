package facebook;

import java.util.Arrays;
import java.util.Comparator;

import static facebook.arden_dertat.Q2_Matrix_Region_Sum.Coordinate;

public class Maximum_Overlapping_Time {
  public static void main(String[] args) {
    int[] start = new int[] {13, 28, 29, 14, 40, 17, 3};
    int[] end = new int[] {107, 95, 111, 105, 70, 127, 74};
    maxOverlap(start, end);
  }

  private static void maxOverlap(int[] start, int[] end) {
    Coordinate[] coordinates = new Coordinate[start.length];
    for(int i = 0; i <start.length; i++) {
      coordinates[i] = new Coordinate(start[i], end[i]);
    }
    Arrays.sort(coordinates, Comparator.comparing(coordinate -> coordinate.x));

    int max_till_now = 1;
    int max = 1;
    Coordinate prev = coordinates[0];
    int max_time = 0;

    int i = 1, j = 0;
    while(i < coordinates.length && j < coordinates.length) {
      Coordinate current = coordinates[i];
      if(current.x <= prev.y) {
        max_till_now++;
        if(max_till_now > max) {
          max_time = current.x;
          max = max_till_now;
        }
        i++;
      } else {
        max_till_now--;
        j++;
      }
    }
    System.out.println("Maximum Number of Guests = "+
        max + " at time " + max_time);
  }
}

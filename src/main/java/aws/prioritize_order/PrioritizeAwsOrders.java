package aws.prioritize_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PrioritizeAwsOrders {
  public static void main(String[] args) {
    List<String> result = prioritizedOrders(6, Arrays.asList("zld 93 12", "fp kindle book", "10a echo show", "17g 17 25 6", "ab1 kindle book", "125 echo dot generation"));
    result.forEach(System.out::println);
  }

  static class IdToMetadata implements Comparable<IdToMetadata> {
    private String id;
    private String metaData;
    private String order;

    public IdToMetadata(String id, String metaData, String order) {
      this.id = id;
      this.metaData = metaData;
      this.order = order;
    }

    @Override
    public int compareTo(IdToMetadata o) {
      if (o.metaData.equals(this.metaData)) {
        return this.id.compareTo(o.id);
      } else {
        return this.metaData.compareTo(o.metaData);
      }
    }
  }

  private static List<String> prioritizedOrders(int numOrders, List<String> orderList) {
    List<String> nonPrimeOrders = new ArrayList<>();
    List<IdToMetadata> primeOrders = new ArrayList<>();

    for (String order : orderList) {
      String[] strList = order.split("\\s");
      if (strList.length > 1) {
        String id = strList[0];
        String metadata = order.replace(id, "").trim();
        if (Pattern.matches("(\\d+\\s*)+", metadata)) {
          nonPrimeOrders.add(order);
        } else {
          primeOrders.add(new IdToMetadata(id, metadata, order));
        }
      }
    }
    Collections.sort(primeOrders);

    List finalList = new LinkedList(primeOrders.stream().map(orders -> orders.order).collect(Collectors.toList()));
    finalList.addAll(nonPrimeOrders);
    return finalList;
  }
}

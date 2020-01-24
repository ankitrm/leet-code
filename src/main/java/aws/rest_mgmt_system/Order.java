package aws.rest_mgmt_system;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
  private int id;

  private List<OrderItem> items;
  public Order(int id) {
    this.id = id;
    items = new ArrayList<>();
  }

  public void addItem(Item item, int quantity) {
    items.add(new OrderItem(item, quantity));
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public String getSummary() {
    return items.stream().map(item -> "Item: " + item.getItem().getId() + ", Quantity " + item.getQuantity()).collect(Collectors.joining("\n"));
  }
}

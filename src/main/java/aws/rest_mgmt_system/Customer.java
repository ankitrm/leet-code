package aws.rest_mgmt_system;

public class Customer {
  private int id;

  private String name;

  private Order order;

  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
    order = new Order(id);
  }

  public void addOrder(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }

  public String summary() {
    return "CustomerId: " + id + ", Name: " + name + ", order: " + order.getSummary();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

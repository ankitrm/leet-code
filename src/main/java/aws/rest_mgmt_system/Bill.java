package aws.rest_mgmt_system;

/**
 * // TODO Comment
 */
public class Bill {
  private Customer customer;
  public Bill(Customer customer) {
    this.customer = customer;
  }

  public int generate() {
    int ans = 0;
    for(OrderItem item : customer.getOrder().getItems()) {
      ans += item.getQuantity() * item.getItem().getPrice();
    }
    return ans;
  }
}

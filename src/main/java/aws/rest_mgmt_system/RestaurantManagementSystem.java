package aws.rest_mgmt_system;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class RestaurantManagementSystem {
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant(
        new Menu(Arrays.asList(
            new Item(1, "Item1", 1),
            new Item(2, "Item2", 2),
            new Item(3, "Item3", 3))),
        3
    );

    Scanner sc = new Scanner(System.in);
    int response;

    int counter = 1;
    do {
      System.out.println("1. Add a new customer\n2. Exit customer\n3. Exit\n");
      response = sc.nextInt();

      if (response == 1) {
        // New Customer coming in
        Customer customer = new Customer(counter, "Customer");
        restaurant.addCustomer(customer);

        if(restaurant.hasFreeTable())
          initiateOrder(restaurant, sc, counter);
        counter++;
      } else if (response == 2) {
        System.out.println(restaurant.getOccupiedTables());
        System.out.println("\nTableId finished: ");
        int tableId = sc.nextInt();
        System.out.println("Bill : " + restaurant.generateBill(tableId));
        restaurant.freeTable(tableId);
        if(restaurant.hasNextCustomer()) {
          initiateOrder(restaurant, sc, counter);
        }
      } else {
        break;
      }
    }
    while (true);
  }

  private static void initiateOrder(Restaurant restaurant, Scanner sc, int counter) {
    // If restaurant has free table
    Optional<Table> table = restaurant.getAvailableTable();
    if (table.isPresent()) {
      Menu menu = restaurant.getMenu();
      Customer customer = restaurant.assignCustomer(table.get());
      System.out.println(menu.displayMenu());
      System.out.println("Customer:: " + customer.getId());
      char hasMoreItems = 'Y';
      Order order = new Order(counter);
      while(hasMoreItems == 'Y' || hasMoreItems == 'y') {
        System.out.println("ItemId : ");
        int itemId = sc.nextInt();

        System.out.println("Quantity : ");
        int quantity = sc.nextInt();

        order.addItem(menu.getItemById(itemId), quantity);

        System.out.println("\nAdd more?");
        hasMoreItems = sc.next().charAt(0);
      }
      customer.addOrder(order);
      System.out.println(restaurant.displayTableSummary(table.get()));
    }
  }
}

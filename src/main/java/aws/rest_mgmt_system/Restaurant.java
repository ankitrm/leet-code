package aws.rest_mgmt_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

class Restaurant {
  private List<Table> tables = new ArrayList<>();
  private Menu menu;
  private List<Bill> bills = new ArrayList<>();
  private Queue<Customer> customersQueue = new LinkedList<>();
  private Map<Integer, Customer> tableCustomer = new HashMap<>();

  public Restaurant(Menu menu, int numTables) {
    for(int i = 0; i <  numTables; i++) {
      this.tables.add(new Table(i));
    }
    this.menu = menu;
  }

  public List<Table> getTables() {
    return tables;
  }

  public Menu getMenu() {
    return menu;
  }

  public List<Bill> getBills() {
    return bills;
  }

  public Optional<Table> getAvailableTable() {
    return tables.stream().filter(table -> !table.isOccupied()).findFirst();
  }

  public void freeTable(int tableId) {
    Table dbTable = tables.stream().filter(table -> table.getId() == tableId).findFirst().orElseThrow(() -> new NoSuchElementException("No table found"));
    dbTable.setOccupied(false);
    tableCustomer.remove(tableId);
  }

  public Customer assignCustomer(Table table) {
    Customer customer = customersQueue.poll();
    tableCustomer.put(table.getId(), customer);
    table.setOccupied(true);
    return customer;
  }

  public void addCustomer(Customer customer) {
    this.customersQueue.add(customer);
  }

  public String getOccupiedTables() {
    return tables.stream().filter(Table::isOccupied).map(Table::getId).collect(Collectors.toList()).toString();
  }

  public int generateBill(int tableId) {
    Customer customer = tableCustomer.get(tableId);
    Bill bill = new Bill(customer);
    bills.add(bill);
    return bill.generate();
  }

  public boolean hasNextCustomer() {
    return !customersQueue.isEmpty();
  }

  public boolean hasFreeTable() {
    return tables.stream().anyMatch(table -> !table.isOccupied());
  }

  public String displayTableSummary(Table table) {
    StringBuilder sb = new StringBuilder();
    sb.append("TableId: ").append(table.getId()).append(tableCustomer.get(table.getId()).summary());
    return sb.toString();
  }
}


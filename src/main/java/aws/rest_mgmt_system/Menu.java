package aws.rest_mgmt_system;

import java.util.List;

class Menu {
  private List<Item> items;

  public Menu(List<Item> items) {
    this.items = items;
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(int id, String name, int price) {
    items.add(new Item(id, name, price));
  }
  public String displayMenu() {
    StringBuilder sb = new StringBuilder();
    for(Item item: items) {
      sb.append(item.getId()).append(": ").append(item.getName()).append(": ").append(item.getPrice()).append("\n");
    }
    return sb.toString();
  }

  public Item getItemById(int itemId) {
    return items.stream().filter(item -> item.getId() == itemId).findFirst().get();
  }
}

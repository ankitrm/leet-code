package aws.rest_mgmt_system;

class Table {
  private int id;
  private boolean isOccupied = false;
  
  public int getId() {
    return id;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void setOccupied(boolean occupied) {
    isOccupied = occupied;
  }

  public Table(int id) {
    this.id = id;
  }
}
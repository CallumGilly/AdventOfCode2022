public class Directory {
  private String name;
  int size;
  public Directory(String name) {
    this.name = name;
    size = 0;
  }

  public void increaseSize(int size) {
    this.size += size;
  }

  public int getSize() {
    return size;
  }

  public int getSize(int maxSize) {
    return size <= maxSize ? size : 0;
  }

  public String getName() {
    return name;
  }
}

import java.util.*;

public abstract class Heap {
  private int capacity;
  private int size = 0;
  private int[] arr;

  // getters
  public int getCapacity() {
    return this.capacity;
  }

  public int getSize() {
    return this.size;
  }

  public int[] getArr() {
    return this.arr;
  }

  // setters
  protected void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  protected void setSize(int size) {
    this.size = size;
  }

  protected void setArr(int[] arr) {
    this.arr = arr;
  }

  protected int getLeftChildIndex(int parentIndex) {
    return (2 * parentIndex + 1);
  }

  protected int getRightChildIndex(int parentIndex) {
    return (2 * parentIndex + 2);
  }

  protected int getParentIndex(int childIndex) {
    return ((childIndex - 1) / 2);
  }

  protected boolean hasLeftChild(int index) {
    return (getLeftChildIndex(index) < size);
  }

  protected boolean hasRightChild(int index) {
    return (getRightChildIndex(index) < size);
  }

  protected boolean hasParent(int index) {
    return (getParentIndex(index) >= 0);
  }

  protected boolean swap(int index1, int index2) {
    if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
      return false;
    } else {
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
      return true;
    }
  }

  protected void ensureCapacity() {
    if (size == capacity) {
      arr = new int[capacity * 2];
      capacity *= 2;
    }
  }

  public int peek() throws Exception {
    if (size == 0) {
      throw new IllegalStateException();
    }
    return arr[0];
  }

  public int poll() throws Exception {
    if (size == 0) {
      throw new IllegalStateException();
    }
    int temp = arr[0];
    swap(0, size - 1);
    size--;
    heapifyDown();
    return temp;
  }

  public void add(int value) {
    ensureCapacity();
    arr[size] = value;
    size++;
    heapifyUp();
  }

  // abstract methods
  abstract protected void heapifyDown();

  abstract protected void heapifyUp();

}

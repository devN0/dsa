import java.util.*;

public class MinHeap extends Heap {
  public MinHeap(int capacity) {
    this.setCapacity(capacity);
    this.setArr(new int[capacity]);
  }

  @Override
  protected void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) { // only need to check for left because if there's no leftChild there will never
                                  // be a right child
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index)) {
        int rightChildIndex = getRightChildIndex(index);
        if (this.getArr()[rightChildIndex] < this.getArr()[smallerChildIndex]) {
          smallerChildIndex = rightChildIndex;
        }
      }
      if (this.getArr()[index] <= this.getArr()[smallerChildIndex]) {
        break;
      } else {
        try {
          swap(index, smallerChildIndex);
        } catch (IndexOutOfBoundsException e) {
          e.printStackTrace();
        }
        index = smallerChildIndex;
      }
    }
  }

  @Override
  protected void heapifyUp() {
    int index = this.getSize() - 1;
    while (hasParent(index)) {
      int parentIndex = getParentIndex(index);
      if (this.getArr()[index] < this.getArr()[parentIndex]) {
        try {
          swap(index, parentIndex);
        } catch (IndexOutOfBoundsException e) {
          e.printStackTrace();
        }
      } else {
        break;
      }
      index = parentIndex;
    }
  }
}

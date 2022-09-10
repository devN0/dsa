import java.util.*;

public class MaxHeap extends Heap {
  public MaxHeap(int capacity) {
    this.setCapacity(capacity);
    this.setArr(new int[capacity]);
  }

  @Override
  protected void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) { // only need to check for left because if there's no leftChild there will never
                                  // be a right child
      int greaterChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index)) {
        int rightChildIndex = getRightChildIndex(index);
        if (this.getArr()[rightChildIndex] > this.getArr()[greaterChildIndex]) {
          greaterChildIndex = rightChildIndex;
        }
      }
      if (this.getArr()[index] >= this.getArr()[greaterChildIndex]) {
        break;
      } else {
        swap(index, greaterChildIndex);
        index = greaterChildIndex;
      }
    }
  }

  @Override
  protected void heapifyUp() {
    int index = this.getSize() - 1;
    while (hasParent(index)) {
      int parentIndex = getParentIndex(index);
      if (this.getArr()[index] > this.getArr()[parentIndex]) {
        swap(index, parentIndex);
      } else {
        break;
      }
      index = parentIndex;
    }
  }
}

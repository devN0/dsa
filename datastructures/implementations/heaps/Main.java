import java.util.*;

public class Main {
  public static void main(String[] args) {
    int[] input = { 5, 6, 11, 3, 12, 15 };
    int n = input.length;
    Heap minHeap = new MinHeap(10);
    Heap maxHeap = new MaxHeap(10);

    System.out.println(Arrays.toString(input));
    for (int i = 0; i < n; i++) {
      minHeap.add(input[i]);
      maxHeap.add(input[i]);
    }
    System.out.println("MinHeap - " + Arrays.toString(minHeap.getArr()));
    System.out.println("MaxHeap - " + Arrays.toString(maxHeap.getArr()));

    try {
      System.out.println(minHeap.poll());
      System.out.println(minHeap.poll());
      System.out.println(minHeap.poll());
      System.out.println(minHeap.poll());
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(Arrays.toString(minHeap.getArr()));

    minHeap.add(2);
    minHeap.add(1);
    minHeap.add(4);
    minHeap.add(14);
    minHeap.add(8);

    System.out.println(Arrays.toString(minHeap.getArr()));
  }
}

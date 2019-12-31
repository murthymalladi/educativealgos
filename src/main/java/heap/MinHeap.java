package heap;

import java.util.Arrays;

/**
 * Created by dmalladi on 12/25/2019.
 */
public class MinHeap {

    private void minHeapify(int[] heapArray, int index, int heapSize) {
        int smallest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < heapSize && heapArray[left] < heapArray[smallest])
            smallest = left;
        if (right < heapSize && heapArray[right] < heapArray[smallest])
            smallest = right;

        if (smallest != index) {
            swap(heapArray,index,smallest);
            minHeapify(heapArray,smallest,heapSize);
        }
    }

    public void buildMinHeap(int[] heapArray, int heapSize) {
        for (int i = heapSize/2; i>= 0; i--)
            minHeapify(heapArray,i,heapSize);
    }

    public static  void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] heapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        new MinHeap().buildMinHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));

    }
}

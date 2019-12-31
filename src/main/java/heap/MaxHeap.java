package heap;

import java.util.Arrays;

/**
 * Created by dmalladi on 12/25/2019.
 */
public class MaxHeap {

    private void maxHeapify(int[] heapArray, int index, int heapSize){
        int largest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;
        if ( (left < heapSize) && (heapArray[left] > heapArray[index]) )
            largest = left;
        if ( (right < heapSize) && (heapArray[right] > heapArray[largest]))
            largest = right;

        if (largest != index) {
            swap(heapArray,index,largest);
            maxHeapify(heapArray,largest,heapSize);
        }

    }

    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void buildMaxHeap(int[] heapArray, int heapSize) {
        for (int i = heapSize/2; i>= 0; i--) {
            maxHeapify(heapArray,i,heapSize);
        }
    }


    public static void main(String[] args) {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        new MaxHeap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));
    }

}

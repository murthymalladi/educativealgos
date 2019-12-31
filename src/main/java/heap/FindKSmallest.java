package heap;

/**
 * Created by dmalladi on 12/25/2019.
 */
public class FindKSmallest {

    public static int[] findKSmallest(int[] arr, int k) {

        int[] kSmallest = new int[k];
        int size = arr.length;
        if (k < size) {
            for (int i = 0; i < k; i++) {
                kSmallest[i] = extractMin(arr,size);
                size--;

            }
        }
        return kSmallest;

    }

    public static int extractMin(int[] heapArray,int heapSize) {
        buildMinHeap(heapArray,heapSize);
        int min = heapArray[0];
        heapArray[0] = heapArray[heapSize-1];
        return min;

    }

    public static void minHeapify(int[] heapArray,int index,int heapSize) {
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

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void buildMinHeap(int[] heapArray,int heapSize) {
        for (int i = heapSize/2; i>= 0; i--)
            minHeapify(heapArray,i,heapSize);
    }

    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKSmallest(input, 3);

        for(int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }

}

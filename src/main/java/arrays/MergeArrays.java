package arrays;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class MergeArrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int length = arr1.length+arr2.length;
        int[] mergedArray = new int[length];
        int i = 0,j=0,k=0;

        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                k++;
                i++;
            }
            else {
                mergedArray[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            mergedArray[k]=arr1[i];
            k++;i++;
        }
        while(j < arr2.length) {
            mergedArray[k] = arr2[j];
            k++;j++;
        }
        return mergedArray;
    }

        public static void main(String args[]) {

        int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
        int[] arr2 = {11,19,27};  // creating a sorted array called arr2

        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for(int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}

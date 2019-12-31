package arrays;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class SecondLargest {

    public static int findSecondMaximum(int[] arr) {
        if (arr.length < 2)
            return 0;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max2 < arr[i]) {
                max2 = arr[i];
            }
            if (max < arr[i]) {
                max2 = max;
                max = arr[i];
           }
        }
        return max2;

    }

    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = {-2, -33, -10, -456};

        System.out.println("Array: " + arrayToString(arr));

        int secMax = findSecondMaximum(arr);

        System.out.println("Second maximum: " + secMax);

    }
}

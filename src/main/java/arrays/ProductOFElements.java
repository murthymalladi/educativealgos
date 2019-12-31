package arrays;

import java.util.Arrays;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class ProductOFElements {

    public static int[] findProduct(int arr[]) {
        int[] prod = new int[arr.length];
        Arrays.fill(prod,1);
        int left =1,right = 1;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            prod[i] = prod[i]*left;
            prod[n-1-i] = prod[n-1-i] * right;
            left = left * arr[i];
            right = right * arr[n-1-i];
        }
        return prod;
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

        int[] arr = {-1, 2, -3, 4, -5};
        //int[] arr = {1,2,3,4};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }
}

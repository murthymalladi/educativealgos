package arrays;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class TwoNumberSum {

    public static int[] findSum(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] arr2 = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(n-arr[i])) {

                arr2[0]= n - arr[i];
                arr2[1] = arr[i];
                return arr2;
            }
            else {
                map.put(arr[i],i);
            }
        }
        return arr2;
    }

    public static void main(String args[]) {

        int n = 9;
        int[] arr1 = {2, 4, 5, 7, 8};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}

package hashtable;

import java.util.HashSet;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class CheckSubSet {

    static boolean isSubset(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i]))
                count++;
        }
        if (count == arr2.length)
            return true;
        return false;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr1, arr3));
    }
}

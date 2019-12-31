package hashtable;

import java.util.HashSet;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class CheckDisjoint {

    public static boolean isDisjoint(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr1.length;i++) {
            if (!set.contains(arr1[i]))
                set.add(arr1[i]);
        }

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i]))
                count++;
        }

        return count == 0;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
        int[] arr2 = {7, 10, 8};
        int[] arr3 = {1, 12};
        System.out.println(isDisjoint(arr1, arr2));
        System.out.println(isDisjoint(arr1, arr3));

    }
}

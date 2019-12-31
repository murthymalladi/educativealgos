package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class CheckFirstUnique {

    public static int findFirstUnique(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1)
                return arr[i];
        }
        return -1;
    }

    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }

}

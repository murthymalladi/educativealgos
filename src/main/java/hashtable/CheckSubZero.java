package hashtable;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class CheckSubZero {

    public static boolean findSubZero(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                return true;
            if (map.containsKey(sum)) {
                return true;
            }
            map.put(sum,i);
        }
        return false;
    }

    public static String findSubZeroRange(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                return String.valueOf(0)+"-"+String.valueOf(i);
            if (map.containsKey(sum)) {
                return String.valueOf(map.get(sum)+1)+"-"+String.valueOf(i);
            }
            map.put(sum,i);
        }
        return "";
    }

    public static void main(String args[]) {

        int[] arr = {6, 4, -7, 3, 12, 9};
        int[] arr2 = {7,6,-3,-2,-5,4,1,2,-3};
        System.out.println(findSubZero(arr));
        System.out.println(findSubZeroRange(arr));

    }
}

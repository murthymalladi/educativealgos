package hashtable;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class CheckPair {

    public static String findPair(int[] arr) {
        String result = "";
        HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {

                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    int[] val = map.get(sum);
                    result = "{"+String.valueOf(val[0])+","+String.valueOf(val[1])+"}";
                    result += ", {"+String.valueOf(arr[i])+","+String.valueOf(arr[j])+"}";
                    return result;
                }
                else {
                    map.put(sum,new int[]{arr[i],arr[j]});
                }

            }
        }
        return result;
    }

    public static void main(String args[]) {

        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(findPair(arr));

    }
}

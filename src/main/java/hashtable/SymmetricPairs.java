package hashtable;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class SymmetricPairs {

    class Pair {
        public int a;
        public int b;
        public Pair(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static String findSymmetric(int[][] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        String result = "";
        for (int[] intArr : arr) {
            int first = intArr[0];
            int second = intArr[1];

            Integer value = map.get(second);
            if (value != null && value == first) {
                result += "{"+String.valueOf(second)+"," + String.valueOf(first)+"}";
            }
            else {
                map.put(first,second);
            }
        }
        return result;
    }

    public static void main(String args[]) {

        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String symmetric = findSymmetric(arr);
        System.out.println(symmetric);

    }
}

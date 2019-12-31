package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class FruitsIntoBasket {

    public static int findLength(char[] arr) {
        int maxLen = Integer.MIN_VALUE;
        int wordStart = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int wordEnd = 0; wordEnd < arr.length; wordEnd++) {
            char rightChar = arr[wordEnd];
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);

            while(map.size() > 2) {
                char leftChar = arr[wordStart];
                map.put(leftChar,map.get(leftChar)-1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                wordStart++;
            }
            maxLen = Math.max(maxLen,wordEnd - wordStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                FruitsIntoBasket.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                FruitsIntoBasket.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}

package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        int maxLen = Integer.MIN_VALUE;
        int wordStart = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int wordEnd = 0; wordEnd < str.length(); wordEnd++) {
            char rightChar = str.charAt(wordEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);

            //nor more than k distinct chars
            while(map.size() > k) {
                char leftChar = str.charAt(wordStart);
                map.put(leftChar,map.get(leftChar)-1);
                if (map.get(leftChar) == 0)
                    map.remove(leftChar);
                wordStart++;
            }
            maxLen = Math.max(maxLen,wordEnd-wordStart+1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}

package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class NoRepeatSubString {

    public static int findLength(String str) {

        int maxLen = 0;
        int wordStart = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int wordEnd = 0; wordEnd < str.length(); wordEnd++) {
            char rightChar = str.charAt(wordEnd);
            if (map.containsKey(rightChar)) {
                wordStart = Math.max(wordStart,map.get(rightChar)+1);
            }
            map.put(rightChar,wordEnd);
            maxLen = Math.max(maxLen,wordEnd - wordStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubString.findLength("abccde"));
    }
}

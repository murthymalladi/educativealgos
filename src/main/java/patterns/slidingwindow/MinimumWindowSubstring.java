package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/29/2019.
 */
public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {
        int wordStart = 0;
        int subStart = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);
        }

        for (int wordEnd = 0; wordEnd < str.length(); wordEnd++) {
            char rightChar = str.charAt(wordEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) >= 0)
                    count++;
            }

            while(count == pattern.length()) {
                if (minLen > wordEnd - wordStart + 1) {
                    minLen = wordEnd - wordStart + 1;
                    subStart = wordStart;
                }
                char leftchar = str.charAt(wordStart);
                if (map.containsKey(leftchar)) {
                    if (map.get(leftchar) == 0) {
                        count--;
                    }
                    map.put(leftchar,map.get(leftchar)+1);
                }
                wordStart++;
            }
        }

        return minLen > str.length() ? "" : str.substring(subStart,subStart+minLen);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}

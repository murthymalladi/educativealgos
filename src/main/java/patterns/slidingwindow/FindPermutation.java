package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/29/2019.
 */
public class FindPermutation {

    public static boolean findPermutation(String str, String pattern) {
        if (str.length() == 0) return false;
        if (pattern.length() == 0) return true;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < pattern.length(); i++)
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);

        int wordStart = 0,matched = 0;

        for (int wordEnd = 0; wordEnd < str.length(); wordEnd++) {
            char rightChar = str.charAt(wordEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) == 0)
                    matched++;
            }
            if (matched == map.size())
                return true;

            if (wordEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(wordStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
                wordStart++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + FindPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + FindPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + FindPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + FindPermutation.findPermutation("aaacb", "abc"));
    }
}

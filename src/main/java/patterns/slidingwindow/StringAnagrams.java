package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dmalladi on 12/29/2019.
 */
public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> res = new ArrayList<Integer>();
        if (str.length() == 0 || pattern.length() == 0) return res;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < pattern.length(); i++)
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);

        int wordStart = 0;
        int matched = 0;
        for (int wordEnd = 0; wordEnd < str.length(); wordEnd++) {
            char rightChar = str.charAt(wordEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == map.size()) {
                res.add(wordStart);
            }
            if (wordEnd >= pattern.length()-1) {
                char leftChar = str.charAt(wordStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        matched--;
                    map.put(leftChar,map.get(leftChar)+1);
                }
                wordStart++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}

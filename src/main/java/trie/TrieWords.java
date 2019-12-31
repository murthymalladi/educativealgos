package trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dmalladi on 12/26/2019.
 */
public class TrieWords {


    public static ArrayList < String > findWords(TrieNode root) {

        ArrayList<String> result = new ArrayList<String>();
        char[] str = new char[20];
        helper(root,result,str,0);
        return result;
    }

    public static void helper(TrieNode root,ArrayList<String> result,char[] str,int level) {

        if (root.isWord) {
            String temp = "";
            for (int i = 0; i < level; i++)
                temp += String.valueOf(str[i]);
            result.add(temp);
        }
        for (int i = 0; i < root.children.length; i++) {

            if (root.children[i] != null) {
                str[level] = (char)('a'+i);
                helper(root.children[i], result, str, level+1);
            }
        }

    }



    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList< String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}

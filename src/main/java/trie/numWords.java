package trie;

import java.util.Arrays;

/**
 * Created by dmalladi on 12/26/2019.
 */
public class numWords {

    public static int totalWords(TrieNode root){
        //base case
        if (root == null)
            return 0;

        int count = 0;
        if (root.isWord)
            count++;
        for (int i = 0; i < root.children.length; i++) {
            TrieNode curr = root.children[i];
            count += totalWords(curr);
        }
        return count;
    }

    public static boolean hasNoChildren(TrieNode root) {
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        System.out.println(totalWords(t.getRoot()));


    }
}

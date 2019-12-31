package trie;

/**
 * Created by dmalladi on 12/26/2019.
 */
public class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }

    public void markAsLeaf() {
        this.isWord = true;
    }

    public void unmarkAsLeaf() {
        this.isWord = false;
    }
}

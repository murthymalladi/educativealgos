package trie;

/**
 * Created by dmalladi on 12/26/2019.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    //index of a character
    public int getIndex(char t) {
        return t - 'a';
    }

    public TrieNode getRoot() {
        return this.root;
    }

    //function to insert key value pair in the trie
    public void insert(String key) {
        if (key == null)
            return;
        key = key.toLowerCase();
        int index = 0;
        TrieNode currNode = this.root;
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];

        }
        currNode.markAsLeaf();
    }

    //function to search given key in the trie
    public boolean search(String key){
        if (key == null)
            return false;

        key = key.toLowerCase();
        int index = 0;
        TrieNode curr = this.root;
        for (int level = 0; level < key.length();level++) {
            index = getIndex(key.charAt(level));
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        if (curr.isWord)
            return true;
        return false;
   }

    //function to delete given key in the trie
    public boolean delete(String key) {
        if (this.root == null || key == null)
            return false;
        key = key.toLowerCase();
        return deleteHelper(this.root,key,key.length(),0);
    }

    public boolean deleteHelper(TrieNode root,String key,int length,int level) {
        boolean isSelfDeleted = false;
        if (root == null) {
            return isSelfDeleted;
        }

        //base case
        if (length == level) {
            if (hasNoChildren(root)) {
                root = null;
                isSelfDeleted = true;
            }
            else {
                root.unmarkAsLeaf();
                isSelfDeleted = false;
            }
        }
        else {
            TrieNode childNode = root.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(childNode,key,length,level+1);
            if (childDeleted) {
                if (root.isWord) {
                    isSelfDeleted = false;
                }
                else if (hasNoChildren(root)) {
                    root = null;
                    isSelfDeleted = true;
                }
                else {
                    isSelfDeleted = false;
                }
            }
            else {
                isSelfDeleted = false;
            }
        }
        return isSelfDeleted;

    }

    public static boolean hasNoChildren(TrieNode root) {
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null)
                return false;
        }
        return true;
    }

}

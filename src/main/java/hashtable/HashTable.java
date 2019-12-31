package hashtable;

import java.util.ArrayList;

/**
 * Created by dmalladi on 12/23/2019.
 */
public class HashTable {

    ArrayList<HashEntry> bucket;
    int slots;
    int size;

    public HashTable() {
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;

        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        return index;
    }

    //insert a value in hashtable
    public void insert(String key,int value) {

        int index = getIndex(key);

        HashEntry head = bucket.get(index);

        while(head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucket.get(index);
        HashEntry newEntry = new HashEntry(key,value);
        newEntry.next = head;
        bucket.add(index,newEntry);

        //check if array >60%
        if ((1.0*size)/slots >= 0.6 ) {

            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<HashEntry>();
            slots = 2 * slots;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            size = 0;
            for (HashEntry node : temp) {
                while(node != null) {
                    insert(node.key,node.value);
                    node = node.next;
                }
            }
        }
    }

    // search a value in table

    public int getvalue(String key) {
        int index = getIndex(key);

        HashEntry head = bucket.get(index);

        while(head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    public int delete(String key) {

        int index = getIndex(key);
        HashEntry head = bucket.get(index);

        HashEntry prev = null;
        while(head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }

        if (head == null)
            return -1;

        size--;
        if (prev != null) {
            prev.next = head.next;
        }
        else {
            bucket.add(index,head.next);
        }

        return head.value;
    }
}

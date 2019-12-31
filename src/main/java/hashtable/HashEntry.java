package hashtable;

/**
 * Created by dmalladi on 12/23/2019.
 */
public class HashEntry {

     String key;
     int value;
     HashEntry next;

     public HashEntry(String key,int value) {
         this.key = key;
         this.value = value;
         next = null;
     }
}

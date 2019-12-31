package hashtable;

import java.util.HashSet;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class RemoveDuplicatesInList {

    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        HashSet<V> set = new HashSet<V>();

        SinglyLinkedList<V>.Node curr = list.getHeadNode();
        SinglyLinkedList<V>.Node prev = list.getHeadNode();

        while(curr != null) {
            if (set.contains(curr.data)) {
                prev.nextNode = curr.nextNode;
                curr = curr.nextNode;
            }
            else {
                set.add(curr.data);
                prev = curr;
                curr = curr.nextNode;
           }

        }
    }

    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}

package hashtable;

import java.util.HashSet;

/**
 * Created by dmalladi on 12/24/2019.
 */
public class UnionIntersection {

    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        HashSet<T> set = new HashSet<T>();
        SinglyLinkedList<T>.Node head1 = list1.getHeadNode();
        SinglyLinkedList<T>.Node head2 = list2.getHeadNode();

        while(head1 != null) {
            if (!set.contains(head1.data)) {
                set.add(head1.data);
                result.insertAtEnd(head1.data);
            }

            head1 = head1.nextNode;
        }

        while(head2 != null) {
            if (!set.contains(head2.data)) {
                result.insertAtEnd(head2.data);
                set.add(head2.data);
            }
            head2 = head2.nextNode;
        }
        return result;
    }

    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        SinglyLinkedList<T>.Node head1 = list1.getHeadNode();
        SinglyLinkedList<T>.Node head2 = list2.getHeadNode();
        HashSet<T> set = new HashSet<T>();
        while(head1 != null) {
            set.add(head1.data);
            head1 = head1.nextNode;
        }

        while(head2 != null) {
            if (set.contains(head2.data)) {
                result.insertAtEnd(head2.data);
            }
            head2 = head2.nextNode;
        }
        return result;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for(int i=7; i>3; i--){
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for(int i=0; i<5; i++){
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        intersectionWithHashing(list1, list2).printList();
        System.out.print("After Union ");
        unionWithHashing(list1, list2).printList();
    }
}

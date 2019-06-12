import java.util.HashSet;

/**
 * PROBLEM 10 : Remove Dups
 * 
 * 1. Write code to remove duplicates from an unsorted linked list.
 * 2. How would you solve this problem if a temporary buffer is not allowed ? 
 */
public class Problem10{

    public static void main(String [] args){

        // Init the list with some values
        LinkedList myList = initLinkedList();
        System.out.print("BEFORE : ");
        myList.display();

        // Solve the problem
        myList = removeDuplicates(myList);

        // Display of the list
        System.out.print("AFTER : ");
        myList.display();
    }

    /**
     * Initialize the LinkedList with some values.
     * Feel free to test other values.
     * @return The Linked List
     */
    public static LinkedList initLinkedList(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(4);

        return list;
    }

    /**
     * SOLUTION 1
     * 
     * Runtime Complexity : O(n)
     * 
     * @param list
     * @return
     */
    public static LinkedList removeDuplicates(LinkedList list){

        HashSet<Integer> charsSet = new HashSet<>();

        Node prev = null;
        Node curr = list.head;
        while(curr != null){
            if(charsSet.contains(curr.data)){
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next; 
            } else {
                charsSet.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }

        return list;
    }
}
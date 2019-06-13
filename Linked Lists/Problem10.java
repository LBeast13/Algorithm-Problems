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
        LinkedList myListSol1 = initLinkedList();
        LinkedList myListSol2 = initLinkedList();

        System.out.print("BEFORE : ");
        myListSol1.display();

        // Solve the problem
        myListSol1 = removeDuplicates(myListSol1);
        myListSol2 = removeDuplicatesPointer(myListSol2);

        // Display of the list
        System.out.print("AFTER SOL 1 (HashTable) : ");
        myListSol1.display();
        System.out.print("AFTER SOL 2 (Two Pointers) : ");
        myListSol2.display();
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
     * SOLUTION 1 : Hash Set
     * 
     * Runtime Complexity : O(n)
     * 
     * I used a HashSet to keep track of the numbers already present
     * in the linked list.
     * So then, when a number is already in the HashSet, I update
     * the "pointer" of the previous node and set it to the next node
     * of the current one.
     *            ___________
     *           |          \|/
     *  ___     _|_   ___   ___
     * |_1_|-->|_2_| |_1_| |_5_|-->
     *  
     * 
     * @param list
     * @return
     */
    public static LinkedList removeDuplicates(LinkedList list){

        HashSet<Integer> values = new HashSet<>();

        Node prev = null;
        Node curr = list.head;

        // Visit all nodes of the list
        while(curr != null){
            
            // It is a duplicated value
            if(values.contains(curr.data)){
                prev.next = curr.next;
            }
            // It is a new value 
            else {
                values.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return list;
    }

    /**
     * SOLUTION 2 : The runner
     * 
     * Runtime Complexity : O(n^2)
     * Space Complexity : O(1)
     * 
     * With no extra buffer available, I used the runner technique.
     * The idea is nearly the same as when we find duplicates in an
     * Array in O(n^2) : we fix a "pointer" to the begining and with
     * another runner "pointer" we iterate the list from the first pointer
     * to the end of the list.
     * Then the logic to remove the duplicate is exactly the same as the solution 1.
     * 
     * @param list The list to remove duplicates
     * @return The list without duplicates values
     */
    public static LinkedList removeDuplicatesPointer(LinkedList list){

        Node current = list.head;   // The current node tocompare with the runner

        // Check every duplicates for every node value in the list
        while(current != null){
            int currValue = current.data;
            
            // Initialize the runner
            Node runner = current;

            // Iterate from the current to the end of the list with the runner
            while(runner.next != null){

                // the runner data is a duplicate
                if(runner.next.data == currValue)
                    runner.next = runner.next.next;

                // The runner data is NOT a duplicate
                else
                    runner = runner.next;
                
            }
            current = current.next;
        }

        return list;
    }
}
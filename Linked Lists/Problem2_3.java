/**
 * PROBLEM 2.3 : Delete Middle node
 * 
 * Implement an algorithm to delete a nde in the middle (ie., any node
 * but the first and last node, not necessarily the exact middle) of
 * a singly linked list, given only access to that node.
 * 
 * EXAMPLE :
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like
 * a->b->d->e->f
 */
public class Problem2_3{

    public static void main(String[] args){
        
        // Init the list with some values
        LinkedList myList = initLinkedList();
        System.out.print("INITIAL LIST : ");
        myList.display();

        // The node to delete
        Node n = myList.head.next;

        System.out.print("AFTER REMOVAL : ");
        removeNode(n);
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
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        return list;
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(1)
     * 
     * Here we only have access to the node we want to delete
     * in the list (not the head).
     * So we just have to copy the value of the next node in this
     * current node and make it point to the same next node of the 
     * next node:
     *    ____________
     *   |          \|/
     *  ___   ___   ___
     * | 2 | | 2 | | 3 |
     * |___| |___| |___|
     * 
     * @param n The node to remove
     */
    public static void removeNode(Node n){
        if(n == null || n.next == null){ 
            System.out.println("Null input or last node of the list...");
        } else{
            n.data = n.next.data;
            n.next = n.next.next;
        } 
    }
}
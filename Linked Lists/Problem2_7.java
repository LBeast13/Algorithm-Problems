/**
 * PROBLEM 2.7 : Intersection
 * 
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
 * node. Note that the intersection is defined based on reference, not value. That is, if the kth
 * node of the first linked list is the exact same node (by reference) as the jth node of the 
 * second linked list, then they are intersecting.
 * 
 */
public class Problem2_7{
    public static void main(String[] args){

        // Init the test data
        LinkedList list1 = new LinkedList();
        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(9);
        list1.add(7);
        list1.add(2);
        list1.add(1);
        
        Node intersec = list1.head.next.next; //Set the 3rd node (5) of the first list as intersection

        LinkedList list2 = new LinkedList();
        list2.add(4);
        list2.add(6);
        list2.add(intersec);
        list2.last = list1.last;

        System.out.print("First linked list : ");
        list1.display();
        System.out.print("Second linked list : ");
        list2.display();

        // Solve
        Node intersecNode = getIntersection(list1, list2);

        // Output
        String answer = (intersecNode == null) ? "No intersections" : "The intersection is " + intersecNode.data ;
        System.out.println(answer);

    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(A + B) where A and B are the lengths of the lists
     * Space Complexity : O(1)
     * 
     * We can observe that two intersecting list have the same tail nodes. Computing the
     * length of both list we can use two pointers with an offset to have the same number
     * of nodes to iterate through for both list. During the iteration, when a node from
     * the first list is equal to the node of the second list, then we have found the 
     * intersection. 
     * 
     * @param list1 The first linked list
     * @param list2 The second linked list
     * @return The intersecting node or null if there is no intersection
     */
    public static Node getIntersection(LinkedList list1, LinkedList list2){
        // Get the length and the tail of each linked list
        LengthAndTail list1Result = getLengthAndTail(list1);
        LengthAndTail list2Result = getLengthAndTail(list2);

        // No intersection because different tails
        if(list1Result.tail != list2Result.tail){
            return null;
        }

        int offset = Math.abs(list1Result.length - list2Result.length);

        // Initialize the two node pointers
        Node shorter = (list1Result.length < list2Result.length) ? list1.head : list2.head;
        Node longer = (list1Result.length < list2Result.length) ? list2.head : list1.head;

        // Put the offset for the longer list pointer
        longer = getNode(longer, offset);

        // Iterate through the list to find the matching node
        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    /**
     * Get the node at the specified position in the linked list
     * 
     * @param listNode the head of the linked list
     * @param position the position of the wanted node
     * @return the node at the specified postiion
     */
    public static Node getNode(Node listNode, int position){
        while(position != 0 && listNode != null){
            position--;
            listNode = listNode.next;
        }

        return listNode;
    }

    /**
     * Iterate the linked list and return it length and tail Node
     * 
     * @param list The list to iterate through
     * @return The length and tail Node of the List
     */
    public static LengthAndTail getLengthAndTail(LinkedList list){
        int length = 0;
        Node curr = list.head;

        while(curr.next != null){
            length++;
            curr = curr.next;
        }

        return new LengthAndTail(length, curr);
    }

    /**
     * A simple class to store the length and the tail Node of a Linked List
     */
    public static class LengthAndTail{
        public int length;
        public Node tail;

        public LengthAndTail(int length, Node tail){
            this.length = length;
            this.tail = tail;
        }
    }
}
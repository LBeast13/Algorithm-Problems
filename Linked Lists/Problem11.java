public class Problem11{

    public static void main(String[] args){
        
        // Init the list with some values
        LinkedList myList = initLinkedList();
        System.out.print("INITIAL LIST : ");
        myList.display();

        int boundary = 4;
        
        System.out.print("THE " + boundary +"th TO LAST ELEMENT : ");
        toLast(myList, boundary);

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
     * Space Complexity : O(1)
     * 
     * I used the runner method again to solve this problem.
     * The idea is to have a "window" bordered by the two node "pointers"
     * with a width equals to k.
     * Then we only have to move this "window" to the end of the list and
     * simply display the nodes present in the window.
     * 
     * @param list The linked list
     * @param k The boundary for the display of the kth to last element of the list
     */
    public static void toLast(LinkedList list, int k){
        // The two node pointers
        Node curr = list.head;
        Node runner = curr;

        // The number of nodes the runner is ahead regarding the current
        int offset = 0;

        // We increase the distance to match the wanted offset
        while(offset<k){
            // Case k is bigger than the list size
            if(runner == null){
                break;
            } else{
                runner = runner.next;
                offset++;
            }
        }

        // Move the "window" of current-runner to the end of the list
        while(runner != null){
            curr = curr.next;
            runner = runner.next;
        }

        /* Display all the nodes after and including the current one 
        (check my LinkedList implementation)*/
        list.displayFrom(curr);
    }
}
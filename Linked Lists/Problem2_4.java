/**
 * PROBLEM 2.4 : Partition
 * 
 * Write code to partition a linked list around a value x, such that all nodes 
 * less than x come before all nodes greater than or equal to x. 
 * If x is contained within the list, the values of x only need to be after the 
 * elements less than x (see below). The partition element x can appear anywhere 
 * in the "right partition"; it does not need to appear between the left and right partitions.
 * 
 * EXAMPLE :
 * Input :   3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * Output:   3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8  
 */
public class Problem2_4{

    public static void main(String[] args){
        
        // Params
        LinkedList initialList = initList();
        int partition = 12;

        System.out.println("Partition element : " + partition);
        System.out.print("Initial List : ");
        initialList.display();

        // Solve
        LinkedList partitionList = makePartition(initialList.head, partition);

        // Output
        System.out.print("Partition List : ");
        partitionList.display();
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n)
     * Space Complexity : O(n)
     * 
     * The idea is to create two linked list, one for each partition (right and left), and to iterate
     * the initial list in order to populate the two lists.
     * Finally, we only merge the two lists.
     * 
     * @param first the first node of the initial list
     * @param partition the partition element
     * @return the partition list
     */
    public static LinkedList makePartition(Node first, int partition){
        LinkedList inf = new LinkedList();
        LinkedList sup = new LinkedList();
        Node curr = first;

        while(curr != null){
            Node next = curr.next;
            curr.next = null;

            if(curr.data < partition){
                inf.add(curr);
            } else{
                sup.add(curr);
            }
            curr = next;
        }

        // Case no left partition, return right
        if(inf.head == null){
            System.out.println("No left partition");
            return sup;
        }
        // Case no right partition, return left
        else if(sup.head == null){
            System.out.println("No right partition");
            return inf;
        } 

        // Merge the right and left partitions
        inf.add(sup.head);
        inf.last = sup.last;

        return inf;
        
    }

    /**
     * Initialize a linked list with some values
     * @return the initial linked list
     */
    public static LinkedList initList(){
        LinkedList list = new LinkedList();
        list.add(8);
        list.add(3);
        list.add(2);
        list.add(8);
        list.add(12);
        list.add(6);
        list.add(5);
        list.add(9);

        return list;
    }
}
import java.util.HashSet;

/**
 * PROBLEM 2.8 : Loop Detection
 * 
 * Given a circular linked list, implement an algorithm that returns the 
 * node at the beginning of the loop.
 * 
 * DEFINITION
 * Circular linked list = A (corrupt) linked list in which a node's next
 * pointer points to an earlier node, so as to make a loop in the linked list.
 * 
 * EXAMPLE
 * Input :  A -> B -> C -> D -> E -> C (the same C as earlier)
 * Output : C
 * 
 */
public class Problem2_8{
    public static void main(String[] args){

        // Init
        LinkedList circularList = initCircularList();

        Node loopingNode = getLoopStartNode(circularList);

        String answer = (loopingNode == null) ? "No loop" : "The looping node is " + loopingNode.data;

        System.out.println(answer);
    }

    public static LinkedList initCircularList(){
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(list.head.next.next); // 3 is the looping node

        return list;
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n) 
     * Space Complexity : O(n)
     * 
     * It is easy to solve this problem by using a HashSet. Indeed, we only
     * have to iterate the list and store the unvisited nodes in the set, and
     * when a node is already present in the set that means it is the looping node.
     * 
     */
    public static Node getLoopStartNode(LinkedList list){
        HashSet<Node> nodeSet = new HashSet<Node>();
        Node curr = list.head;

        while(curr != null){
            if(nodeSet.contains(curr)){
                return curr;
            } else {
                nodeSet.add(curr);
                curr = curr.next;
            }
        }

        return null;
    }
}
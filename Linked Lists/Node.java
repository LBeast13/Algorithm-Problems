/**
 * Represents the Linked List node
 */
public class Node{

    /**
     * The "pointer" to the next node
     */
    Node next;

    /**
     * The value of the node
     */
    int data;

    public Node(){ 
        next = null;
    }

    public Node(int data){
        next = null;
        this.data = data;
    }

    /**
     * Check if a node has a following node
     * @return true if it has a following node, false either
     */
    public boolean hasNext(){
        return next == null ? false : true;
    }
}
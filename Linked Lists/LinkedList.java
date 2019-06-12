import Node.java;

/**
 * This is my simple Linked List implementation to store int values.
 */
public class LinkedList{

    /**
     * First Node of the linked list
     */
    Node head;

    /**
     * Last Node of the linked list
     */
    Node last;

    public LinkedList(){
        head = null;
        last = null;
    }

    /**
     * Add a new node at the end of the linked list
     * 
     * @param n
     */
    public void add(Node n){

        if(head != null){    // The list is not empty
            last.next = n;
            last = n;
        }
        else{   // The list is empty
            head = n;
            last = n;
        }
    }

    /**
     * Add a new node with the specified value at the end of the linked list
     * 
     * @param val The value for the new Node
     */
    public void add(int val){

        Node n = new Node(val);

        if(head != null){   // The list is not empty
            last.next = n;
            last = n;
        }
        else{   // The list is empty
            head = n;
            last = n;
        }
    }

    /**
     * Print the entire list in the console
     */
    public void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data);
            if(curr != last)
                System.out.print(" --> ");
            curr = curr.next;
        }
        System.out.println();
    }

    
}


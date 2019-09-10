/**
 * PROBLEM 2.6 : Palindrome
 * 
 * Implement a function to check if a linked list is a palindrome.
 * 
 */
public class Problem2_6{

    public static void main(String[] args){

        //Init
        LinkedList list = initList();

        System.out.print("The linked list : ");
        list.display();

        // SOLVE
        String answer = (isPalindromeList(list)) ? "Is a palindrome" : "Is NOT a palindrome";

        // OUTPUT
        System.out.println(answer);
    }

    public static LinkedList initList(){
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(2);

        return list;
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n)
     * Space Complexity : O(n)
     * 
     * The idea is to reverse the linked list and compare it with the initial one
     * node by node.
     * If a node is different from the node at the same position in the other list
     * then it is definitely not a palindrome.
     * 
     * @param list The linked list for the palindrome check
     * @return True if the list is a palindrome, false otherwise
     */
    public static boolean isPalindromeList(LinkedList list){
        // Reverse the linked list
        LinkedList revList = reverseList(list);

        Node curr = list.head;
        Node currRev = revList.head;

        // Iterate the initial and reversed list for comparision
        while(curr != null){
            if(curr.data != currRev.data){
                return false;
            }

            curr = curr.next;
            currRev = currRev.next;
        }

        return true;
    }

    /**
     * Reverse the linked list.
     * 
     * @param list The linked list to reverse
     * @return The reversed linked list
     */
    public static LinkedList reverseList(LinkedList list){
        LinkedList rev = new LinkedList();

        Node curr = list.head;

        while(curr != null){
            Node prevHead = rev.head;
            rev.head = new Node(curr.data);
            rev.head.next = prevHead;

            curr = curr.next;
        }

        return rev;
    }
}
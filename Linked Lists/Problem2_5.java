/**
 * PROBLEM 2.5 : Sum Lists
 * 
 * You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such 
 * that the 1's digit is at the head of the list. Write a function that adds
 * the two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * 
 * Input : (7 -> 1 -> 6) + (5 -> 9 -> 2) That is, 617 + 295
 * Output : 2 -> 1 -> 9. That is, 912.
 */
public class Problem2_5{

    public static void main(String [] args){

        // First Number
        LinkedList firstNb = new LinkedList();
        firstNb.add(7);
        firstNb.add(1);

        // Second Number
        LinkedList secondNb = new LinkedList();
        secondNb.add(5);
        secondNb.add(9);
        secondNb.add(2);

        System.out.print("First Number : 17 = ");
        firstNb.display();
        System.out.print("Second Number : 295 = ");
        secondNb.display();

        // Solve
        LinkedList sum = linkedSum(firstNb.head, secondNb.head);

        //Output
        System.out.print("The linked list sum is : ");
        sum.display();

    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(n)
     * Space Complexity : O(n)
     * 
     * The idea is to iterate both lists (numbers to sum) at the same time and to
     * make the sum of each node.
     * The problem is when the sum number for two nodes is greater than 9 because
     * then we have two digits. To fix that we will get the 1's digit by taking the
     * rest of the euclidian division of the nodes, and the other digit (the carry)
     * will be computed as a simple division casted to an integer. 
     * By doing this we can go to the next node and making another sum without forgeting
     * to add the carry !
     * 
     * @param nb1 The first node of the first number
     * @param nb2 The first node of the second number
     * @return The sum as a linked list (reverse)
     */
    public static LinkedList linkedSum(Node nb1, Node nb2){
        LinkedList sum = new LinkedList();

        // Iterate the linked lists
        while(nb1 != null || nb2 != null){
            if(nb1 == null){    // The first list has been fully iterated
                sum.add(nb2);
            } else if(nb2 == null){     // The second list has been fully iterated
                sum.add(nb1);
            } else {
                int tempSum = nb1.data + nb2.data;

                Node newNode = new Node(tempSum % 10);  // Rest of the Euclidian division
                sum.add(newNode);

                // Propagate the carry
                if(nb1.next != null){
                    nb1.next.data = nb1.next.data + tempSum/10;
                } else if (nb2.next != null){
                    nb2.next.data = nb2.next.data + tempSum/10;
                } else {
                    Node finalNode = new Node(tempSum/10);
                    sum.add(finalNode);
                }
            }
            nb1 = (nb1 == null) ? null: nb1.next;
            nb2 = (nb2 == null) ? null: nb2.next;
        }

        return sum;
    }


}
/**
 * PROBLEM 3.2 : Stack Min
 * 
 * How would you design a stack which, in adition to push and pop, has a function
 * min which returns the minimum element ? Push, pop and min should all operate in
 * O(1) time.
 * 
 * SOLUTION :
 * 
 * The idea here is to store for each node, the min value under it (substack) 
 * including itself.
 * 
 */
public class StackMin{
    /**
     * The class for a node of the Stack
     */
    private static class StackNode{
        private int data;
        private StackNode next;
        private int subStackMin;

        public StackNode(int data, int subStackMin){
            this.data = data;
            this.subStackMin = subStackMin;
        }
    }

    private StackNode top;

    /**
     * Add the specified value to the top of the stack
     * and update the min.
     * @param value the value to add
     */
    public void push(int value){
        int min = Integer.MAX_VALUE;

        if (this.top != null) {
            min = this.top.subStackMin;
        }

        min = (min > value) ? value : min;

        StackNode newNode = new StackNode(value, min);
        newNode.next = this.top;
        this.top = newNode;
    }

    /**
     * Remove the node on the top of the stack
     * @return The removed value.
     */
    public int pop(){
        if(this.top == null){
            return -1; //Error
        }
        int popedVal = this.top.data;
        this.top = this.top.next;
        return popedVal;
    }

    /**
     * @return the minimum element of the stack
     */
    public int min(){
        if(this.top == null){
            return Integer.MAX_VALUE; //error
        }
        return this.top.subStackMin;
    }

}
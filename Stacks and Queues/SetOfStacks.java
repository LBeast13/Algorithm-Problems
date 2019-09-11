import java.util.ArrayList;

/**
 * PROBLEM 3.3 : Stack of Plates
 * 
 * Imagine a (literal) stack of plates. If the stack gets too high,
 * it might topple. Therefore, in real life, we would likely start a
 * new stack when the previous stack exceeds some threshold. Implement
 * a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the 
 * previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * should behave identically to a single stack (that is, pop() should return
 * the same values as it would if there were just a single stack).
 * 
 * SOLUTION :
 * 
 * To solve this we need a list of stacks. Each stack will have the same nodes 
 * capacity defined by the SetOfStacks data structure (threshold).
 * When a stack is full we just create a new stack in the list.
 */
public class SetOfStacks{

    /**
     * Stack inner class
     */
    private  class Stack{
        /**
         * Stack node inner class
         */
        private  class StackNode{
            private int data;
            private StackNode next;

            public StackNode(int data){
                this.data = data;
            }
        }

        private StackNode top;
        private int capacity;

        public Stack(int capacity){
            this.capacity = capacity;
        }

        /**
         * Add the specified value to the top of the stack if it has space
         * @param value the value to add
         */
        public void push(int value){
            if(this.capacity == 0){
                return; //error
            }

            StackNode newNode = new StackNode(value);
            newNode.next = this.top;
            this.top = newNode;

            this.capacity--;
        }

        /**
         * Remove the node on the top of the stack and update capacity
         * @return The removed value.
         */
        public int pop(){
            if(this.top == null){
                return Integer.MAX_VALUE; //error
            }

            int popedVal = this.top.data;
            this.top = this.top.next;
            this.capacity++;

            return popedVal;
        }

        /**
         * Check if the stack is full (capacity = 0)
         */
        public boolean isFull(){
            return this.capacity <= 0;
        }

        /**
         * @return the top element of the stack
         */
        public int peek(){
            return this.top.data;
        }
    }

    private int threshold;
    private ArrayList<Stack> subStacks;

    public SetOfStacks(int threshold){
        this.threshold = threshold;
        subStacks = new ArrayList<Stack>();
    }

    /**
     * Add a new Stack Node to the current Stack if it is
     * not full, otherwise it create a new stack.
     * @param value The new stack node value
     */
    public void push(int value){
        Stack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(value);
        } else {
            Stack newStack = new Stack(threshold);
            newStack.push(value);
            subStacks.add(newStack);
        }
    }

    /**
     * Remove the top stack node from the last stack.
     * If the last stack is empty after the pop, then
     * we remove the stack from the stacks list.
     * @return the removed element
     */
    public int pop(){
        Stack last = getLastStack();
        if(last == null){
            return Integer.MAX_VALUE; //Error empty stack
        }
        int valuePoped = last.pop();
        if(last.capacity == threshold){
            subStacks.remove(subStacks.size()-1);
        }
        return valuePoped;
    }

    /**
     * @return The last Stack of the list
     */
    private Stack getLastStack(){
        if(subStacks.isEmpty()){
            return null;
        }
        return subStacks.get(subStacks.size() - 1);
    }

    /**
     * @return the top of the general stack
     */
    public int peek(){
        return getLastStack().peek();
    }

    /**
     * @return the number of stacks
     */
    public int getSubStacksNbr(){
        return this.subStacks.size();
    }
}
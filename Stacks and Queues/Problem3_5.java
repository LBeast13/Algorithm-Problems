import java.util.Stack;

/**
 * PROBLEM 3.5 : Sort Stack
 * 
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements 
 * into any other data structure (such as an array). The stack supports the 
 * following operations: push, pop, peek and isEmpty.
 */
public class Problem3_5{
    public static void main(String[] args){

        // Init
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.push(6);
        stack.push(4);

        // Solve
        stack = sortStack(stack);

        // Output
        display(stack);
        
    }

    /**
     * SOLUTION
     * 
     * We can only use an extra stack for the sort. The idea here is to
     * insert the nodes of the first stack in the second in a sorted order
     * (big nodes on top).
     * To achieve that we pop a node from the first stack and store it in a
     * temp variable. We then compare the peek of the second stack with the 
     * poped node :
     *      - if the peek is lower than the popped node, then we can push
     *      the popped node directly in the second stack.
     *      - otherwise we pop the peek and push it to the first stack. We
     *      then compare the new peek with the initial popped node and so on.
     * 
     * When the first stack is empty, we move all the nodes from the temp stack
     * to the first stack and the sort is finished.
     * 
     * @param stack The stack to sort
     * @return the sorted stack
     */
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<Integer>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        // Move all the nodes to the first stack
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return stack;
    }

    /**
     * Display the given stack
     */
    private static void display(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
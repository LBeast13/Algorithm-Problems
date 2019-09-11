/**
 * PROBLEM 3.4 : Queue Via Stacks
 * 
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * SOLUTION :
 * The idea here is that, when a new node is added we add it to a stack 
 * (stackNewFirst) and when we want to remove a node or get the peek of
 * the queue, we pop every node of this stack and we push them in the 
 * other stack (stackOldFirst). We do this shift only when it is necessary
 * (for a pop or peek call and only if the stackOldFirst is empty).
 */
public class QueueViaStacks{
    Stack<T> stackNewFirst, stackOldFirst;

    public QueueViaStacks(){
        stackNewFirst = new Stak<T>();
        stackOldFirst = new Stak<T>();
    }

    public int size(){
        return stackNewFirst.size() + stackOldFirst.size();
    }

    /**
     * We add the new node to the stackNewFirst.
     */
    public void add(T value){
        stackNewFirst.push(value);
    }

    /**
     * We shift all the nodes from the stackNewFirst to the stackOldFirst
     * but only if the second stack is empty (old first).
     */
    public void shiftStacks(){
        if(stackOldFirst.isEmpty()){
            while(!stackNewFirst.isEmpty()){
                stackOldFirst.push(stackNewFirst.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();
        return stackOldFirst.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOldFirst.pop();
    }
}
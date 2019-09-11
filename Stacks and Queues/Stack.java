import java.util.EmptyStackException;

/**
 * A custom implementation of a Stack with StackNode inner class.
 * @param <T> The type of the StackNodes of the Stack
 */
public class Stack<T>{

    /**
     * The class for a node of the Stack
     * @param <T> The Node type
     */
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    /**
     * Add the specified value to the top of the stack
     * @param value the value to add
     */
    public void push(T value){
        StackNode newNode = new StackNode<T>(value);
        newNode.next = this.top;
        this.top = newNode;
    }

    /**
     * Remove the node on the top of the stack
     * @return The removed value.
     */
    public T pop(){
        if(this.top == null){
            throw new EmptyStackException();
        }
        T popedVal = this.top.data;
        this.top = this.top.next;
        return popedVal;
    }

    /**
     * @return the value of the node at the top of the Stack
     */
    public T peek(){
        if(this.top == null){
            throw new EmptyStackException();
        }
        return this.top.data;
    }

    /**
     * Check if the Stack is empty
     * @return True if the Stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.top == null;
    }
}
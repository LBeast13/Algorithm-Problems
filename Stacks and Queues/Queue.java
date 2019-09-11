import java.util.NoSuchElementException;

/**
 * A custom implementation of a Queue usins QueueNode inner class.
 * @param <T> The type of the QueueNodes of the Stack
 */
private class Queue<T>{

    /**
     * The class for a node in the Queue
     */
    private static class QueueNode<T>{

        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    /**
     * Add a new node to the back of the queue with the given value.
     * @param value The value for the new element.
     */
    public void add(T value){
        QueueNode<T> newNode = new QueueNode<T>(value);
        if(last != null){
            this.last.next = newNode;
        }
        this.last = newNode;

        if(this.first == null){
            this.first = this.last;
        }
    }

    /**
     * Remove the first element of the queue and return its value.
     * @return the value of the removed element.
     */
    public T remove(){
        if(this.first == null){
            throw new NoSuchElementException();
        }
        T value = this.first.data;
        this.first = this.first.next;

        if(this.first == null){
            this.last = null;
        }
        return value;
    }

    /**
     * @return the value of the first element of the Queue
     */
    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return this.first.data;
    }

    /**
     * @return True if the Queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return first == null;
    }
}
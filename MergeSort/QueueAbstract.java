import java.util.Arrays;


public class QueueAbstract<E> implements Queue<E> {

    protected int head;
    protected int tail;
    protected int count;
    private E[] data;
    
    public QueueAbstract(int count) {
        this.count = count;
        data = (E[]) new Object[this.count];
        //currentSize = 0;
        head = 0;
        tail = 0;
    }
    
    public void enqueue(E item)
    // post: the value is added to the tail of the structure
        {
        add(item);
        }
    
    public E dequeue()
    // pre: the queue is not empty
    // post: the head of the queue is removed and returned
        {
        return remove();
        }
    
    public E getFirst()
    // pre: the queue is not empty
    // post: the element at the head of the queue is returned
        {
        return get();
        }
    
    public E peek()
    // pre: the queue is not empty
    // post: the element at the head of the queue is returned
        {
        return get();
        }

    public void add(E value){ // post: the value is added to the tail of 
        int tail = (head + count) % data.length; 
        data[tail] = value; 
        count++;
    }
    
    public E remove() { // pre: the queue is not empty // post: the head of the queue is removed and returned 
        E value = (E)data[head]; 
        data[head] = null;
        head = (head + 1) % data.length; 
        count--; 
        return value;
    }
   
    public E get() { // pre: the queue is not empty // post: the element at the head of the queue is returned 
        return (E)data[head];
    } 
   
    public int size(){ // post: returns the number of elements in the queue 
        return count;
    }
    
    public boolean empty() {
        if (count != 0) {
            return false;
        }
        return true;
    }
    public String toString() {
        return "Queue [" + Arrays.toString(data) + "]";
    }
    
}

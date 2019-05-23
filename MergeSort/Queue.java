
public interface Queue<E>
{
        public void add(E value);
        // post: the value is added to the tail of the structure
        public void enqueue(E value);
        // post: the value is added to the tail of the structure
        public E remove();
        // pre: the queue is not empty
        // post: the head of the queue is removed and returned
        public E dequeue();
        // pre: the queue is not empty
        // post: the head of the queue is removed and returned
        public E getFirst();
        // pre: the queue is not empty
        // post: the element at the head of the queue is returned
        public E get();
        // pre: the queue is not empty
        // post: the element at the head of the queue is returned
        public E peek();
        // pre: the queue is not empty
        // post: the element at the head of the queue is returned
        public boolean empty();
        // post: returns true if and only if the queue is empty
        public int size();
        // post: returns the number of elements in the queue
}

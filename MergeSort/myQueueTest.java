
public class myQueueTest
{
    public static void main(String[] args) {
        QueueAbstract<Integer> q = new QueueAbstract(10);
        
        q.enqueue(14);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);
        q.enqueue(19);
        q.enqueue(20);
        q.enqueue(21);
        q.enqueue(22);

        System.out.println("\nFull Queue: " + q.toString());

        q.dequeue();
        System.out.println("Dequeue: " + q.toString());
        
        q.enqueue(24);
        System.out.println("After enqueueing element with value 24: "+ q.toString());
        
        
    }
}

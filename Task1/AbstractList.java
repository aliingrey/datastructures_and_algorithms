public abstract class AbstractList<E> implements List<E> {
    protected int elementCount;
    
    public boolean isEmpty(){
        return elementCount==0;
    }
    
}


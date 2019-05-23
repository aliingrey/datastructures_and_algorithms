public interface List<E>  {
    
    public E get(int i);
    // pre: 0 <= i < size()
    // post: retuns the ith entry of list 
    
    public E set(int i, E value);
    // pre: 0 <= i < size()
    // post: sets ith entry of list to value,
    // returns old value
    
    
    public void add(int i, E value);
    // pre: 0 <= i <= size()
    // post: adds value at ith index of the List

    public E remove(int i);
    // pre: 0 <= i < size()
    // post: removes and returns object found at that location

   
    
}

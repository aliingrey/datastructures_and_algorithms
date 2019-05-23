public class ArrayList<E> extends AbstractList<E> implements List<E>{
    private Object[] elementData;
    private int size; //Capacity of ArrayList


    public ArrayList() { 
        this(10);
        elementCount=0; 
        size=10;
    }


    public ArrayList(int initialCapacity) { 
       if (initialCapacity < 0) 
           throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity); 

       this.elementData = new Object[initialCapacity]; 
       size=initialCapacity;
       elementCount=0;
    } 
        
    public E get(int index) { 
        rangeCheck(index); 
        return (E) elementData[index]; 
    }

    public E set(int index, E element) { 
            rangeCheck(index); 
            E oldValue = (E) elementData[index]; 
            elementData[index] = element; 
            return oldValue; 
    } 

    private void rangeCheck(int index) { 
            if (index >= size || index < 0) 
                throw new IndexOutOfBoundsException("out Of Bound index");
    }
        

    public void add(int index, E element) {     
        rangeCheck(index);
        if(elementCount+1<=size){ 
            for (int i=elementCount-1; i>=index; i--)
                elementData[i+1]=elementData[i];
        
            elementData[index]=element;
            elementCount++; // Increments  the element count of the array
            }       
    }


    public E remove(int index) { 
       rangeCheck(index); 
       E oldValue = (E) elementData[index]; 
       for (int i=index; i<elementCount; i++)
           elementData[i]=elementData[i+1];

       elementData[--elementCount]=null;
       return oldValue; 
    }
 
        
} 

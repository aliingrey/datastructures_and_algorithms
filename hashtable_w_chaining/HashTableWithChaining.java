import java.util.Scanner;
import java.util.Objects;

class HashTableWithChaining 
{
    public linkedlist[] table;
    
    //number of buckets to store data
    private int size ;
 
    public HashTableWithChaining (int capacity)
    {
        table = new linkedlist[nextPrime(capacity)];
        size = 0;
    }

    public void clear() //Clears data from hash table 
    {
        size = 0;
        int length = table.length;
        table = new linkedlist[length];
    }

    public int getSize()
    {
        return size;
    }
    
    public void put(String name, int age, String city) //inserts person element
    {
        size++;
        
        //puts name through hash function, puts it in bucket according to result of function
        int bucket = hashfunction(name); 
        
        //new singlylinkedlist for a new person with corresponding data
        linkedlist newperson = new linkedlist(name, age, city);  
        
        if (table[bucket] == null) //if no data, add a new person
            table[bucket] = newperson;            
        else //if data, find put a new person where data ends
        {
            newperson.next = table[bucket];
            table[bucket] = newperson;
        }    
    }

    //removes person
    public void remove(String name)

    {
        //find position of person to be removed
        int pos = hashfunction(name);
        if (table[pos] != null){
            linkedlist previous = null;
            linkedlist current = table[pos];
            String listname = current.data;
            if (listname != name) {   
                if (previous == null){
                    table[pos] = current.next;
                }  else {
                    previous = previous.next;
                }
               size--;
               System.out.println(name + " removed.");
            }
        } else {
            System.out.println(name + " could not be found in this hash table. the person's name you inputted is not removed.");
        }
    }

    //hash function that returns integer hash value to find which bucket to put data
    private int hashfunction(String name)
    {
        int hashvalue = name.hashCode( );
        hashvalue %= table.length;
        if (hashvalue < 0) {
            hashvalue += table.length;
        }            
        return hashvalue;
    }
    
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for ( ; !isPrime( n ); n += 2);
 
        return n;
    }
    private static boolean isPrime( int n )
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    
    
    public void copydata(HashTableWithChaining temp) {
        /* 
         * used to copy data to new hash table when expanding size
         */
        for(int i = 0; i<size; i++) {
            linkedlist person = this.table[i];
            while(person != null)
            {
                   temp.put(person.data, person.age, person.city);
                   person = person.next;
             }
        }
    }

    public void printHashTable ()
    {
        for (int i = 0; i < table.length; i++)
        {
            System.out.println();
            System.out.print ("Bucket " + (i + 1) + ":  ");             
            linkedlist person = table[i];
            while(person != null)
            {
                System.out.print("  [" + person.data + ", " + person.age + ", " + person.city + "]   ");
                person = person.next;
            }
        }
    }   
}
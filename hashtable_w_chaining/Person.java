import java.util.Objects;
import java.util.Scanner;
import java.util.*;

public final class Person {
    public final String name;
    public int age;
    public String city;
    public Object[] persondata;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name + ", age " + age + ", from " + city;
    }
    
    public Object[] getpersondata() {
        persondata[0] =name;
        persondata[1] =age;
        persondata[2] =city;
        return persondata;
    }
    
    public String getName() {
        return name;
    }
    public static void main(String[] args) 
    {
        System.out.println("Hash Table of People\n");
        
        int numbuckets = 2;
        HashTableWithChaining  h = new HashTableWithChaining (numbuckets);
        
        //number of people that can be inserted before expanding
        int capacity = numbuckets + 1;
        
        Scanner scan = new Scanner(System.in);
        String name;
        int age;
        String city;
        char ch;
        do    
        {
            System.out.println("\nHash Table of People!\n");
            System.out.println("1. insert a person");
            System.out.println("2. remove a person");
            System.out.println("3. clear the table");
            System.out.println("4. get size of the hash table"); 
 
            int menu = scan.nextInt();            
            switch (menu)
            {
                case 1 : 
                    System.out.println("You're entering a new person. Enter their name, age, and hometown");
                    name = scan.next();
                    age = scan.nextInt();
                    city = scan.next();
                    
                    Person myperson = new Person(name, age, city);
                    myperson.toString();
                    h.put(myperson.name, myperson.age, myperson.city); 
                               
                    if (h.getSize() > (capacity*.75)) {
                        int newcapacity = h.getSize()*2;
                        System.out.println("\nCapacity has reached 75% of table, double number of buckets to reduce collision.");
                        System.out.println("expanding hash table size from " + h.getSize() + " to " + newcapacity);

                        HashTableWithChaining temp = new HashTableWithChaining(newcapacity);
                        h.copydata(temp);
                        h = temp;  
                    }
                    break;                          
                case 2 :                 
                    System.out.println("Enter the name of the person to delete");
                    Scanner sc = new Scanner(System.in);
                    String n = sc.nextLine();
                    h.remove(n);
                    break;                        
                case 3 : 
                    h.clear();
                    System.out.println("Hash Table Cleared\n");
                    break;                   
                case 4 : 
                    System.out.println("Size = "+ h.getSize() );
                    break;
                default : 
                    System.out.println("Invalid Choice");
                    break;   
            }
            h.printHashTable(); 
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');
        
    }
    
}
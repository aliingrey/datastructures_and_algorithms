import java.util.Scanner; 
/*
import java.util.HashSet;
import java.util.HashMap;
*/
public class MyBST {
    
    public static void main(String[] args) {
        System.out.println("");
        String data;
        int key;
        BinarySearchTree bst = new BinarySearchTree();  
        /*
        
       /*
        //User is going to enter one (key, value) pair at a time. 
        bst.add(7,"Dog");
        bst.add(56,"Cat");
        bst.add(24,"Mouse");
        bst.add(88,"Parrot");
        bst.add(88,"Kiwi");
        
        System.out.println("in order traversal");
        bst.traversal(bst.root);
        
        System.out.println("\n");
        System.out.println("key set    " + bst.keyset());
        System.out.println("value set  " + bst.values());
        System.out.println("entry set  " + bst.entryset().toString());
        
        //Implement a treeHeight() method to return the height of your binary search tree.
        System.out.println("\nHeight of tree is : " + bst.height(bst.root)); 
        
        //Your get() function should return all the values stored against a key OR null if that key does not exist.
        System.out.println("get value of 56" + bst.get(bst.root, 56));
        */
       
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n");

        String value;
        int getkey;
        char ch;
        do    
        {
            System.out.println("\n\n");
            System.out.println("1. insert ");
            System.out.println("2. view");
            System.out.println("3. height of tree");
            System.out.println("4. use get() method to return a value of a given key");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
                case 1 : 
                    System.out.println("Enter an integer key value and an associated value separated by a space");
                    key = scan.nextInt();
                    value = scan.nextLine();
                    bst.add(key,value);
                    break;                          
                case 2 :                 
                    System.out.println("in order traversal");
                    bst.traversal(bst.root);
                    
                    System.out.println("\n");
                    System.out.println("key set    " + bst.keyset());
                    System.out.println("value set  " + bst.values());
                    System.out.println("entry set  " + bst.entryset().toString());
                    break;                        
                case 3 : 
                    System.out.println("\nHeight of tree is : " + bst.height(bst.root)); 
                    break;  
                case 4 : 
                    System.out.println("\nEnter a key you wish to get the  associated value of ");
                    getkey = scan.nextInt();
                    System.out.println("The value of " + getkey + " is" + bst.get(bst.root, getkey));
                    break;
                default : 
                    System.out.println("Wrong Entry \n ");
                    break;   
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }      
}

    


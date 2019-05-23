import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class BinarySearchTree { 
      public BSTNode root = null;
      public BSTNode node;
      public BSTNode front;
      public BSTNode last;
      //create HashSets to store values of keys, values, and their associated pairs
      Set<Integer> keys = new HashSet();
      Set<String> values = new HashSet();
      Set<BSTNode> entry = new LinkedHashSet();
      public int count = 0;
    
    protected BSTNode locate(BSTNode root, int value)
    // pre: root and value are non-null
    // post: returned: 1 - existing tree node with the desired value, or
    // 2 - the node to which value should be added
    {
        if(root == null) {
            return null;
        }
        int rootValue = root.value();
        BSTNode child=null;
        // found at root: done
        if (rootValue==value) return root;
        
        // look left if less-than, right if greater-than
        if (rootValue <= value)
            child = root.right();
        else 
            child = root.left();
        
        // no child there: not in tree, return this node, else keep searching
        if (child==null) 
            return root;
        else 
            return locate(child, value);
    
    }

    protected BSTNode predecessor(BSTNode root)
    {
        if(root!=null)
        {
            System.out.println("No predecessor to middle value.");
            //return null;
        }
        if(root.left!=null)
        {
            System.out.println("Root has left child.");
        }
        
        BSTNode result = root.left();
        while (result.right!=null) {
        result = result.right();
        }
        return result;
    }
    
    public boolean contains(BSTNode node, int value){
        if(node == null) {
            return false;
        }
        
        //goes through tree and recursively calls itself until it finds the data is equal to the value
        if (value > node.data) //right 
        {
            return contains(node.left, value);
        } else if (value == node.data){
            return true;
        } else  /* if (value < node.data) */ {
            return contains(node.right, value);
        } 
    }
    public void add(int key, String value) // post: adds a value to binary search tree
    {
        if (contains(root, key)) {
            //if the tree already has the key, find the location and add the value 
            BSTNode location = locate(root,key);
            location.setvalue(value);
        } else {
            BSTNode newNode = new BSTNode(key, value);
            // add value to binary search tree
            // if there's no root, create value at root
            if (root==null) {
                root = newNode;
            } else {
                BSTNode insertLocation = locate(root,key);
                int nodeValue = insertLocation.value();
                // The location returned is the successor or predecessor
                // of the to-be-inserted value
                if (nodeValue < key) {
                    insertLocation.setRight(newNode);
                } else {
                    if (insertLocation.left!=null) {
                        // if value is in tree, we insert just before
                        predecessor(insertLocation).setRight(newNode);
                        
                    } 
                    else {
                        insertLocation.setLeft(newNode);
                    }
                }
                newNode.setParent(insertLocation);
            }
            count++;
        }
    }

    public void traversal(BSTNode node) { 
        //in order traversal of the binary search tree
        if (node == null) {
            return; 
        }
        traversal(node.left);
        
        //add data to the keys set
        keys.add(node.data);
        
        //add string value to the value set
        values.add(node.value);
        
        //add data of each node to the entry set
        entry.add(node);
        System.out.print(node.data + " "); 
        traversal(node.right);
    }
    
    public Set keyset(){
        return keys;
    }
   
    public Set values(){
        return values;
    }
    
    public Set <BSTNode> entryset(){
        return entry;
    }

    public int height(BSTNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            //find the depth of each side of the tree
            int leftdepth = height(node.left); 
            int rightdepth = height(node.right); 
   
            //use the height of whichever subtree is larger
            if (leftdepth > rightdepth) {
                return (leftdepth + 1); 
            } else {
                return (rightdepth + 1); 
            }
        } 
    } 
    
    public String get(BSTNode node, int key) { //get returns the value given a key
        //if there is no integer, return nothing
        if (node == null) {
            return "the key you asked for " + key + " is not in this BST.";
        }
        
        if (key < node.data) {
            /* if the value of the key is less than the data at the given node
             * get the value of the left, which has a lesser value than the node
             */
            return get(node.left, key);
        } else 
        if (key > node.data) {
            /* if the value of the key is greater than the data at the given node
             * get the value of the right, which has a greater value than the node
             */
            return get(node.right, key);
        } 
        else { // if node.data == x
            return node.value;
        }
    }
    
}
  

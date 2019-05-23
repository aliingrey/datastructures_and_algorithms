public class BSTNode {
  public int data;
  String value;
  public BSTNode parent;
  public BSTNode left;
  public BSTNode right;
  public BSTNode link;

  public BSTNode() {
    data = (Integer) null;
    parent=left=right=null;
  }
  public BSTNode(int val) {
    data = val;
    //value = str;
    parent=null;
    left=right=null;
  }
  
  public BSTNode(int val, String str) {
    data = val;
    value = str;
    parent=null;
    left=right=null;
  }
  
  public BSTNode(int val, BSTNode p, String str) {
    value = str;
    data = val;
    parent=p;
    left=right=null;
  }

  public BSTNode(BSTNode l,int val, BSTNode r, String str) {
    value = str;
    data = val;
    parent=null;
    left=l;
    right=r;
  }
  
     public BSTNode left()
        // post: returns reference to (possibly empty) left subtree
     {
         return this.left;
     }
     public BSTNode right()
        // post: returns reference to (possibly empty) left subtree
     {
         return this.right;
     }
     
    public BSTNode parent()
    // post: returns reference to parent node, or null
    {
        return this.parent;
    }
    
    public void setLeft(BSTNode newLeft)
    // post: sets left subtree to newLeft
    {
        this.left=newLeft;
        
    }
    
    public void setRight(BSTNode newRight)
    // post: sets left subtree to newLeft
    {
        this.right=newRight;
        
    }
    
    // re-parents newLeft if not null
    public void setParent(BSTNode newParent)
    // post: re-parents this node to parent reference, or null
    {
        this.parent=newParent;
    }

    public boolean isLeftChild()
    // post: returns true if this is a left child of parent
    {
        if(this.parent.left==this)
            return true;
        else
            return false;
    }
    public boolean isRightChild()
    // post: returns true if this is a left child of parent
    {
        if(this.parent.right==this)
            return true;
        else
            return false;
    }
    
    public int value()
    
    {
        return this.data;
    }
    
    public String getValue() {
        // post: returns value associated with this node
        return this.value;
    }
    
    public int getKey() {
        return this.data;
    }
    public void setvalue(String s){ 
        //key, adds value (node class - , + data) of key to the data string
        this.value +=",";
        this.value +=s;
    }
    
    public int data(){
        return this.data;
    }
    
    public String toString(){
        //makes entryset into a string value for user to view
        return "(" + this.getKey() + ", " + this.getValue() + ")";
    }  
    
}

public class TreeNode /*implements BinaryTree*/{
  public Object data;
  public TreeNode parent;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
    //data = null;
    //parent=left=right=null;
  }
  
  public TreeNode(Object data) {
    this.data = data;
    //left=right=null;
  }
  /*
  public TreeNode(char val, TreeNode p) {
    data = val;
    parent=p;
    left=right=null;
  }
*/
/*
 public BinaryTree left()
    // post: returns reference to (possibly empty) left subtree
 {
     return this.left;
 }
 */
/*
 public BinaryTree right()
    // post: returns reference to (possibly empty) left subtree
 {
     return this.right;
 }
    public BinaryTree parent()
    // post: returns reference to parent node, or null
    {
        return this.parent;
    }
    
    public void setLeft(TreeNode newLeft)
    // post: sets left subtree to newLeft
    {
    	if (isEmpty()) return;
    	if (left != null && left.parent() == this)
    	left.setParent(null);
    	left = newLeft;
    	left.setParent(this);
        //this.left=newLeft;
    }
    public void setRight(TreeNode newRight)
    // post: sets left subtree to newLeft
    {
    	if (isEmpty()) return;
    	if (right != null && right.parent() == this)
    	left.setParent(null);
    	left = newRight;
    	left.setParent(this);
        //this.right=newRight;
    }
    */
   /*
    // re-parents newLeft if not null
    public void setParent(TreeNode newParent)
    // post: re-parents this node to parent reference, or null
    {
    	if (!isEmpty()) {
    		parent = newParent;
    		}
        this.parent=newParent;
    }
//public Iterator<E> iterator()
    // post: returns an in-order iterator of the elements
    
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
    
    public Object value()
    // post: returns value associated with this node
    {
        return this.data;
    }
    */
    /*
    public void setValue(value)
    // post: sets the value associated with this node
    {
        this.data=value;
    }
    */
   /*
    public boolean isEmpty()
    //post: returns true if the data of the node is null else returns false
    {
        if(this.data == (' '))
            return true;
        else
            return false;
    }
    */
}
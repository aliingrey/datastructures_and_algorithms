import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class mainClass
{

    
    public static String replacevariables(String expression) {
        Scanner sc = new Scanner(System.in);

        //Put the characters of the string into an arrayList.
        char[] strChar = expression.toCharArray();
        ArrayList<String> strList = new ArrayList();
        for (int i = 0; i < strChar.length; i++) {
            strList.add(String.valueOf(strChar[i]));
        }

        //Checking letters:
        for (int i = 0; i < strList.size(); i++) {
            if (Character.isLetter(strChar[i])) {
                String foundvar = strList.get(i); //The found letter should be replaced.
                System.out.println("Please enter the value of " + String.valueOf(foundvar));
                String value = "";
                do {
                    boolean validinput = false;
                    while (validinput == false) {
                        try {
                            value = sc.nextLine();
                            validinput = true;
                            Integer.parseInt(value); //see if it's a number
                        } catch (NumberFormatException e) {
                            System.out.println("Value must be a number. Enter a new value ");
                            validinput = false;
                        }
                    }
                } while (Character.isDigit(Integer.parseInt(value)));

                //Replace each occurence of the same letter 
                for (int j = 0; j < strList.size(); j++) {
                    if (strList.get(j).equals(foundvar)) {
                        strList.set(j, value);
                    }
                }
            }
        }

        //Put all characters back into a new string.
        String newString = "";
        for (int i = 0; i < strList.size(); i++) {
            newString += strList.get(i);
        }

        return newString;
    }

    private static boolean isOp(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    private static boolean isStringOp(String input)
    {
        return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"));
    }
    public static boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }
    public static boolean isValidExpression(char[] array) {
        int openparens = 0;
        int closedparens = 0;
        int arraylength = array.length;
        
        //make sure input is either letter, number, or operator (for example, no '$' or '#')
        for (int i = 0; i < array.length; i++){ 
            if (Character.isLetter(array[i]) || (Character.isDigit(array[i])) || isOperator(array[i]) == true) {
                //System.out.println("All input is valid.");
            } else {
                return false;
            }
        }
       
        //makes sure for every open parentheses, it has a closed match
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ('(')) {
                openparens++;
            } else if (array[i] == (')')) {
                closedparens++;
            }            
        }
        if (openparens != closedparens) {
            return false;
        }
        
        //operator can't begin or end an expression
        if ( isOp(array[0]) || isOp(array[arraylength - 1])) {
            return false;
        }
        return true;
    }

    private static boolean isOperator(char c) { //includes parentheses for expresion check
        if (c == '(' || c == ')' || c == '-' || c == '+' || c == '*' || c == '/') {
            return true;
        } else {
            return false;
        }
    }

    public static TreeNode createTree(ArrayList<TreeNode> nodes) {
        //base case , simple expression 
        if (nodes.size() == 3){ 
            return branch(nodes.get(0), nodes.get(1), nodes.get(2));
        } else {
            TreeNode mytree = null; //creates the TreeNode that will be returned
            boolean hasparens = false; //sees if there are parens that need to be first priority to be evaluated
            boolean needsMD = false; //next priority: needs multiplication or division
            
            //solve inside parens first
            int openparens = 0; //keeps track of left/right parens
            int closedparens = 0;
            for (int i = 0; i < nodes.size(); i++){
                if(nodes.get(i).data.equals("(")){
                    hasparens = true; //sees left parens, know we need to solve
                    openparens++;
                    for (int j = i+1; j < nodes.size(); j++){
                        
                        if(nodes.get(j).data.equals("(")) {
                            openparens++;
                        }
                        if(nodes.get(j).data.equals(")")) {
                            closedparens++;
                        }
                        
                        //if balanced parens, go in and solve the inside parens first with new ArrayList
                        //searches for right parens to see where parens ends
                        if (closedparens == openparens) {
                            //move everything to a new node
                            ArrayList<TreeNode> insideparens = new ArrayList<>();
                            TreeNode parensroot;
                            for (int k = i + 1; k < j; k++) {
                                insideparens.add(nodes.get(k));
                            }
                            //building tree of just the things inside the parens
                            parensroot = createTree(insideparens); //build operation inside parens
                            //remove everything inside
                            for (int l = j; l >= i; l--) {
                                nodes.remove(l);
                            }
                            nodes.add(i, parensroot); //adding i to the parentheses position
                            /*
                            for(TreeNode treeNode:nodes){
                                System.out.print(treeNode.data);
                            }
                            */
                            mytree  = createTree(nodes); //continue building operation recursively
                        }
                    }
                }                
            }
            //multiplication/division part
            //after parens are solved (& removed)
            if (hasparens == false){ 
                    for (int i = 0; i < nodes.size(); i ++) {    
                        //follows next order of operations - goes for multiplication or division
                        if (nodes.get(i).data.equals("*") || nodes.get(i).data.equals("/")) {
                            needsMD = true;
                            //build a branch to do the multiplication within it
                            nodes.set(i, branch(nodes.get(i - 1), nodes.get(i), nodes.get(i+1))); //making a branch of the node and two numbers next to it
                            nodes.remove(i+1);
                            nodes.remove(i-1);
                            
                            mytree = createTree(nodes); //continues building recursively
                        }
                    }
                    //when addition/subtraction is what's left
                    if (needsMD == false){
                        nodes.set(1, branch(nodes.get(0), nodes.get(1), nodes.get(2)));
                        nodes.remove(2);
                        nodes.remove(0);
                        mytree = createTree(nodes);
                   }
                }
            return mytree;
        }
        
    }
    public static TreeNode branch(TreeNode left, TreeNode parent, TreeNode right) {
        parent.left = left;
        parent.right = right;
        return parent;
    }
    public static String postorder(TreeNode node, String postfix) {
            
        if (node == null) {
            return "";
        }
        String postorderstring = ""; 
        postorderstring += postorder(node.left, postfix); //data of left child
        postorderstring += postorder(node.right, postfix); //data of right child
        postorderstring += node.data; //data of this node        
        return postorderstring;
        
    }
    public static void evaluate(String postfix) {
        Stack<Double> numberstack = new Stack();
        double num1;
        double num2;
        double result = 0;
        for (int i = 0; i < postfix.length(); i++) {
            if (isDigit(String.valueOf(postfix.charAt(i)))) {
                numberstack.push(Double.parseDouble(String.valueOf(postfix.charAt(i))));
            }
            if (isStringOp(String.valueOf(postfix.charAt(i)))) {
                num2 = numberstack.pop();
                num1 = numberstack.pop();
                switch (String.valueOf(postfix.charAt(i))) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1/num2;
                        break;
                }
                numberstack.push(result);
            }

        }
        System.out.println("final result: " + numberstack.peek());
    }

    public static void main (String[] args)
    {
       Scanner str = new Scanner(System.in);
       System.out.println("\nEnter the expression: ");
       String userinput = str.nextLine();
       String expression = replacevariables(userinput);
       
       char[] array = expression.toCharArray();
       System.out.println("valid expression : " + isValidExpression(array));
       boolean isValid;
       do {
           isValid = isValidExpression(array);
           if (isValid == false) {
               System.out.println("enter a new expression");
               expression = str.nextLine();
               array = expression.toCharArray();
            }
       } while (isValid == false);
           
       ArrayList<TreeNode> nodes = new ArrayList<>();
       for (int i = 0; i < expression.length(); i++) {
              nodes.add(new TreeNode(String.valueOf(expression.charAt(i))));
       }
            
       TreeNode root = createTree(nodes);
       String postorderstring = postorder(root, "");
       System.out.println("Post order: " + postorderstring);
       evaluate(postorderstring);  
    }
        
 }
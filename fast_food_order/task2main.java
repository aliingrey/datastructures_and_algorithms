//Author: Ali Ingrey
//DSA Assignment 2, Task 2

import java.util.Scanner;
import java.util.LinkedList; 
import java.util.Queue; 

public class task2main
{
    public static void main (String[] args)
    {
	//create 3 lines for customers to choose between
       Queue<Integer> dinein = new LinkedList<>(); 
       Queue<Integer> takeout = new LinkedList<>(); 
       Queue<Integer> drivethrough = new LinkedList<>(); 
	//creates a queue for orders that have been made.
       Queue<Integer> readyorders = new LinkedList<>(); 
       
       Scanner input = new Scanner(System.in);
       int menu;
        do {            
            System.out.println();
            System.out.println("Welcome! Which line would you like to join? Select from the following:");
            System.out.println("1: Dine In");
            System.out.println("2: Take Out");
            System.out.println("3: Drive Through");
            System.out.println("4: view size of lines");
            System.out.println("5: to see if order is ready");
            System.out.println("0: To Exit");
            System.out.println();
            System.out.println("customers waiting in dine in queue "+ dinein); 
            System.out.println("customers waiting in takeout queue "+ takeout);
            System.out.println("customers waiting in drive through queue "+ drivethrough);
            System.out.println("customers that have been served "+ readyorders);

            menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1: {
                    int customerid = (int )(Math.random() * 100 + 1);
                    System.out.println("you've joined the dine in queue, your customer number is " + customerid);
                    dinein.add(customerid);
                    System.out.println("customers waiting in dine in queue "+ dinein); 
                    break;
                }
                case 2: {
                    int customerid = (int )(Math.random() * 100 + 1);
                    System.out.println("you've joined the take out queue, your customer number is " + customerid);
                    takeout.add(customerid);
                    System.out.println("customers waiting in takeout queue"+ takeout);
                    break;
                } case 3: {
                    int customerid = (int )(Math.random() * 100 + 1);
                    System.out.println("you've joined the drive through queue, your customer number is " + customerid);
                    drivethrough.add(customerid);
                    System.out.println("customers waiting in drive through queue"+ drivethrough);
                    break;
                } case 4: {
                   int dineinwait = dinein.size();
                   int takeoutwait = takeout.size();
                   int drivethroughwait = drivethrough.size();
                   System.out.println("Size of dine in queue: " + dineinwait + " customers"); 
                   System.out.println("Size of take out queue: " + takeoutwait + " customers");
                   System.out.println("Size of drive through queue: " + drivethroughwait + " customers");
                } case 5: {
				//random generator to see if an order is ready
				//generates a random number between 1 and 100
                    int randomnumber = (int )(Math.random() * 100 + 1);
				//depending on the remainder of the number, the orders in a given line may be ready
                    if (randomnumber%5 == 0 && dinein.isEmpty() == false) {
                        int readyorder = dinein.peek();
                        System.out.println("Dine in order " + readyorder + " is ready");
                        dinein.remove();
                        readyorders.add(readyorder);
                    } else if (randomnumber%5 == 1 && takeout.isEmpty() == false) {
                        int readyorder = takeout.peek();
                        System.out.println("Take out order " + readyorder + " is ready");
                        takeout.remove();
                        readyorders.add(readyorder);
                    } else if (randomnumber%5 == 2 && drivethrough.isEmpty() == false) {
                        int readyorder = drivethrough.peek();
                        System.out.println("Drive through order " + readyorder + " is ready");
                        drivethrough.remove();
                        readyorders.add(readyorder);
                    } else {
                        System.out.println("Sorry, there are no orders ready at this time. Check again soon!");
                    }
                } case 0: {
                    System.out.println("\n");
                    break;
                }
                default: {
                    System.out.println("Invalid option!\n");
                    break;
                }
        }
    } while (menu != 0);
}
}


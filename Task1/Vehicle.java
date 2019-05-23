import java.util.Scanner;

public class Vehicle {
    public static final int NUMBER_OF_SPOTS = 10;
    private String registrationNum;
    public static int timeParked;
    public int parkingCost;
    
    public Vehicle(String registrationNum, int timeParked) {
        this.registrationNum = registrationNum;
        this.timeParked = timeParked;
    }
   
    public String getregistrationNum() {
        return registrationNum;
    }
    public static int getTime() {
        return timeParked;
    }
    public int getTimeParked() {
        if(timeParked < 1) {
            parkingCost = 4;
        } else if (timeParked < 2 && timeParked >= 1) {
            parkingCost = 8;
        } else if (timeParked < 5 && timeParked >= 2) {
            parkingCost = 12;
        } else if (timeParked <= 5) {
            parkingCost = 24;
        }
        return parkingCost;
    }

    public static void main(String[] args) {
        
        ArrayList parkingArray = new ArrayList();
        Scanner input = new Scanner(System.in);
        int menu;
        String model;

        do {
            System.out.println("WELCOME TO PARKING MANAGEMENT");
            System.out.println("1: To Park Vehicle");
            System.out.println("2: To Leave Structure");
            System.out.println("3: To View Spots");
            System.out.println("0: To Exit");

            menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1: {
                    System.out.println("Enter Registration Number");
                    String registrationNum = input.next();

                    System.out.println("Which spot would you like to park? \nChoose spots #0 - " + NUMBER_OF_SPOTS);
                    
                    int spotNumber = input.nextInt();
                    if (parkingArray.get(spotNumber) == null) {
                        System.out.println("Your car is parked " + "at spot #" + spotNumber);
                        parkingArray.add(spotNumber,registrationNum);
                        
                        System.out.println("How many hours do you plan to stay?");
                        int timeParked = input.nextInt();
                        
                        Vehicle myCar = new Vehicle(registrationNum, timeParked);

                        int parkingCost;
                        if(timeParked < 5) {
                            parkingCost = timeParked*4;
                            System.out.println("Cost to park: $" + parkingCost);

                        } else if (timeParked <= 5) {
                            parkingCost = 24;
                            System.out.println("Cost to park: $" + parkingCost);
                         
                        }
                    } else {
                        System.out.println("Sorry, this spot is taken.");
                    }

                break;
                }
                case 2: {
                    System.out.println("Enter your spot number.");
                    int spotNumber = input.nextInt();
                    if (parkingArray.get(spotNumber) == null) {
                            System.out.println("There's no car in parking spot " + spotNumber);
                    } else {
                            System.out.println("Leaving parking spot " + spotNumber);
                            parkingArray.set(spotNumber, null);
                            System.out.println("You've left the structure.");
                    }
                    break;
                }
                case 3: {
                    for (int i = 0; i < NUMBER_OF_SPOTS; i++) {
                        if (parkingArray.get(i) == null) {
                            System.out.println("Spot #" + i + " is open");
                        } else {
                           System.out.println("Spot #" + i + " is occupied by car " + parkingArray.get(i) + " parked for " + getTime() + " hours.");
                        }
                    }
                }
                case 0: {
                    System.out.println("\n");
                    break;
                }
                default: {
                    System.out.println("Invalid option!\n");
                    break;
                }
            }
            System.out.println("  ");
        } while (menu != 0);

    }

}
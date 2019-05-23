public class Vehicle {
    private final int id;
    private final int spacesNeeded; 
    private final double costFactor;
    private String vehicleType;
    public Vehicle(String vehicleType, int id, int spacesNeeded, double costFactor) {
        super();
        this.vehicleType = vehicleType;
        this.id = id;
        this.spacesNeeded = spacesNeeded;
        this.costFactor = costFactor;
    }
    public int getSpacesNeeded() {
        return spacesNeeded;
    }
    public double getCostFactor() {
        return costFactor;
    }
    @Override
    public String toString() {
        return String.format("Vehicle [vehicleType=%s, id=%d, spacesNeeded=%d, costFactor=%.2f]", vehicleType, id,
                spacesNeeded, costFactor);
    }   
}


/*
import java.util.Scanner;
public class Vehicle {
    

    private String carBrand;
    private String regPlate;

    // default constructor
    public Vehicle() {
    }

    // constructor
    public Vehicle(String carBrand, String regPlate) {
        this.carBrand = carBrand;
        this.regPlate = regPlate;
    }

    //getters
    public String getCarBrand() {
        return carBrand;
    }

    public String getRegPlate() {
        return regPlate;
    }

    //setters
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setColor(String regPlate) {
        this.regPlate = regPlate;
    }
    public static void main(String[] args) {
        //CarParkManager myCarPark = new CarParkManager();
        
        Scanner input = new Scanner(System.in);
        int menu;
        String model;

        do {
            System.out.println("WELCOME TO PARKING MANAGEMENT");
            System.out.println("1: To Park Vehicle");
            System.out.println("2: To Departure");
            System.out.println("3: Show All Perked Vehicles");
            System.out.println("0: To Exit");

            System.out.print("Enter your choice: ");

            menu = input.nextInt();
            System.out.println();

            switch (menu) {
                case 1: {
                    String vType;

                    System.out.println("Please choose The Vehicle type");
                    System.out.println("C = Car");
                    System.out.println("B = Motorbike");
                    System.out.println("V = VAN");
                    vType = input.next();
                    if (vType.equals("C")) {
                        System.out.println("Vehicle Registration Number");
                        String regPlate = input.next();
                    } else if (vType.equals("B")) {

                    } else if (vType.equals("V")) {
                    }

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {
                    System.out.println("List of All Parked Vehicles : ");
                    break;
                }

                case 0: {
                    System.out.println("\nThank you!\n");
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
*/

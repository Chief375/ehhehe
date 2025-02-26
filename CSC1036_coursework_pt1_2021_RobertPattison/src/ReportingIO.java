import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ReportingIO class has the main method of the program and
 * contains all the methods that deals with the IO of the program.
 */

public class ReportingIO {

    /**
     * A method which creates a new branch object and adds it to the reporting object.
     * This is done by taking in the name and then asking how many sales they want to add
     * to the branch. This then runs the {@link ReportingIO#salesData()} method to add all the
     * required sales. Finally, it creates the branch object and adds it to the reporting object.
     * @param reporting a Reporting object that holds all the branches.
     */
    //Creates a branch object and adds it to the reporting object
    public static void enterBranchData(Reporting reporting) {
        //Creates a scanner to get user data
        Scanner branchData = new Scanner(System.in);
        //Gets name of branch from user
        System.out.println("Please enter the name for this branch: ");
        String branchName = branchData.nextLine();
        //Gets amount of sales that user wants to add
        System.out.println("How many sales would you like to add: ");
        int numberOfSales = branchData.nextInt();
        //Creates a sales ArrayList to store all the sales
        ArrayList<Sale> branchSales = new ArrayList<>();
        //Runs while the number of sales is above 0
        while(numberOfSales != 0) {
            //Creates new sale and adds it to the ArrayList
            Sale tempSale = salesData();
            branchSales.add(tempSale);
            numberOfSales -= 1;
        }
        //Creates a Branch and adds it to the reporting object
        Branch tempBranch = new Branch(branchName,branchSales);
        reporting.addBranch(tempBranch);
    }

    /**
     * A method that gets all sale data from a user and creates a new sale object.
     * This is done by first creating a scanner and getting all the required parameters
     * for the Sale constructor.
     * @return a Sale object that represents the sale of a house.
     */
    //Creates a sale object
    public static Sale salesData() {
        //Gets all data for parameters for sale constructor
        Scanner salesData = new Scanner(System.in);
        System.out.println("Please enter the sales data below: ");
        System.out.println("Enter house number: ");
        int houseNumber = salesData.nextInt();
        System.out.println("Enter postcode: ");
        salesData.nextLine();
        String postcode = salesData.nextLine();
        System.out.println("Enter value: ");
        int value = salesData.nextInt();
        salesData.nextLine();
        System.out.println("Enter month sold: ");
        String monthSold = salesData.nextLine();
        System.out.println("Enter year sold: ");
        int yearSold = salesData.nextInt();
        //Creates new sale object and returns it
        Sale tempSale = new Sale(houseNumber, postcode, value, monthSold, yearSold);
        return tempSale;
    }

    /**
     * A method to add a sales object to a given branch. This is done by first
     * getting the name of the branch that the user wants to add a sale to then
     * calling the {@link ReportingIO#salesData()} method. Then it loops through all branches
     * until it finds the right branch, it then adds it to the branch.
     * @param reporting a Reporting object that holds all the branches.
     */
    //Creates a sale object and adds it to a given branch
    public static void enterSalesData(Reporting reporting) {
        //Creates scanner to get user input
        Scanner salesData = new Scanner(System.in);
        //Prints all of reporting to see all branch names
        System.out.println(reporting);
        //Asks user to what branch they want to add to
        System.out.println("Which branch would you like to enter the sales data to: ");
        String desiredBranch = salesData.nextLine();
        //Creates sale object
        Sale tempSale = salesData();
        //Loops through all branches
        for (Branch branch : reporting.getBranches()) {
            //Finds branch with name given by user and then adds the sale to that branch.
            if (branch.getNameOfBranch().matches(desiredBranch)) {
                branch.addSale(tempSale);
            }
        }
    }

    /**
     * A method to get all the statistics about all the branches. This is done
     * by calling all methods from the Reporting class.
     * @param reporting a Reporting object that holds all the branches.
     */
    //Outputs data about the branches in the reporting class
    public static void getStatisticalData(Reporting reporting) {
        //Asks user for parameters for reporting class methods
        Scanner statisticalData = new Scanner(System.in);
        System.out.println("Please enter a year to for the largest average sale: ");
        int desiredYear = statisticalData.nextInt();
        System.out.println("Please enter an amount for all sales to be greater then: ");
        int desiredAmount = statisticalData.nextInt();
        System.out.println("The branch with the largest average sale value in " + desiredYear + " is: " + reporting.highestAverageSaleInYear(desiredYear));
        System.out.println("The highest sale ever reported is: " + reporting.largestSaleEver());
        System.out.println("All sales above " + desiredAmount + " are: " + reporting.salesAboveValue(desiredAmount));
    }

    /**
     * The main method to run the entire program and holds the menu that the
     * user uses to add new data and see the statistics, as well as exit the
     * program.
     * @param args
     */
    public static void main(String[] args) {
        //Defines a blank ArrayList to create a new Reporting object.
        ArrayList<Branch> branches = new ArrayList<>();
        Reporting reportingBranch = new Reporting(branches);
        boolean running = true;
        Scanner text = new Scanner(System.in);
        //Loop to keep program running until it is exited.
        while(running) {
            System.out.println("What would you like to do? \n Enter B: To add branch data \n Enter S: To enter sale data \n Enter D: To get statistical data \n Enter E: To exit");

            //Takes user input and validates it to make sure capitalisation does not matter and it only accepts chars.
            char choice = text.next().charAt(0);
            char upperCaseChoice = Character.toUpperCase(choice);
            //Menu for user to choose what they want to do
            if (upperCaseChoice == 'E') {
                System.out.println("Thank you for using this program.");
                running = false;
            }
            if (upperCaseChoice == 'B') {
                enterBranchData(reportingBranch);
            }
            if (upperCaseChoice == 'S') {
                enterSalesData(reportingBranch);
            }
            if (upperCaseChoice == 'D') {
                getStatisticalData(reportingBranch);
            }
        }
    }
}

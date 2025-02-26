import java.util.ArrayList;

/**
 * The Reporting class creates a reporting object, which holds
 * all the Branch objects and uses methods to get certain statistics
 * on about all the branches.
 */

public class Reporting {

    //Defining attributes for the class
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    /**
     * This is the constructor for the reporting class.
     * @param branches an ArrayList representing all of Branch objects
     */
    //Constructor for the Reporting class
    public Reporting(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    /**
     * A getter for the {@link Reporting#branches} attribute.
     * @return an ArrayList of branch objects.
     */
    //All setters and getters for Reporting class
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    /**
     * A setter for the {@link Reporting#branches} attribute.
     * @param branches an ArrayList of branch objects.
     */
    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    /**
     * A method to add a single branch to the {@link Reporting#branches} ArrayList.
     * @param branch a Branch object.
     */
    //Adds a single Branch object to the branches ArrayList.
    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    /**
     * A method to get the largest sale from all branches by
     * looping through all branch objects and getting the highest
     * value from each one and comparing them to each other,to find
     * the highest.
     * @return an integer representing the largest sale ever done by a branch.
     */
    //Finds the highest sale ever in a branch.
    public int largestSaleEver() {
        int largestSale = 0;
        //Loops through all branch objects
        for (Branch branch: branches) {
            //Uses highestSale() method within branch to find the highest value
            if (branch.highestSale() > largestSale) {
                largestSale = branch.highestSale();
            }
        }
        return largestSale;
    }

    /**
     * A method to get all sales in all branches which have a value
     * above a certain amount. This is done by taking an ArrayList of an
     * ArrayList of sales and then looping through all branches and finding
     * all values above in that branch and adding them to ArrayList of an ArrayList.
     * @param desiredValue an integer value of a desired amount for all sales value to be greater than.
     * @return an ArrayList of an ArrayList of sales that represents all sales above a certain amount.
     */
    //Finds all sales above a certain value
    public ArrayList<ArrayList<Sale>> salesAboveValue(int desiredValue) {
        //This is an ArrayList of an ArrayList of sales
        ArrayList<ArrayList<Sale>> allSales = new ArrayList<>();
        //Loops through all branches
        for (Branch branch : branches) {
            //Calls saleAboveAmount() method to find all sales above desiredValue then adds it to allSales ArrayList
            allSales.add(branch.saleAboveAmount(desiredValue));
        }
        return allSales;
    }

    /**
     * A method to find the highest average sale of houses in a certain year.
     * This is done by looping though all branches, then through all the sales
     * in that branch. Then finding all the sales within the desired year and
     * calculating the average within that branch.
     * @param desiredYear an integer value representing the year for finding the average.
     * @return a String representing the name of the branch with the highest average in a given year.
     */
    //Finds the highest average sale in a given year.
    public String highestAverageSaleInYear(int desiredYear) {
        String branchWithHighest = null;
        int highestValue = 0;
        //Loops through all branches.
        for (Branch branch : branches) {
            //Reset values with every new branch
            int averageSale = 0;
            int count = 0;
            //Loops through all sale values
            for (Sale sale: branch.getSales()) {
                //Checks whether the yearSold is the same as the given year and increase the average
                if (sale.getYearSold() == desiredYear) {
                    averageSale += sale.getValue();
                    count += 1;
                }
            }
            //Checks whether the current average is greater than the highest average
            if (averageSale == 0) {
                return "No data available for that year";
            }
            if (averageSale/count > highestValue) {
                branchWithHighest = branch.getNameOfBranch();
                highestValue = averageSale/count;
            }
        }
        return branchWithHighest;
    }

    /**
     * This allows for easier reading of a Reporting object
     * @return a String representing a Reporting object.
     */
    @Override
    public String toString() {
        return "Reporting{" +
                "branches=" + branches +
                '}';
    }
}

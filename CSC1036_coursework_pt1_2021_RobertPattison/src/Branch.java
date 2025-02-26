import java.util.ArrayList;

/**
 * The Branch class creates a branch object which represents
 * an estate agents branch in a certain area and what house sales
 * have happened in it.
 */

public class Branch {

    //Defining attributes of Branch
    private String nameOfBranch;
    private ArrayList<Sale> sales = new ArrayList<Sale>();

    /**
     * This is the constructor for the Branch class.
     * @param nameOfBranch represents the name/area of the branch.
     * @param sales represents all the sales that have occurred in that branch.
     */
    //Constructor for the Branch class
    public Branch(String nameOfBranch, ArrayList<Sale> sales) {
        this.nameOfBranch = nameOfBranch;
        this.sales = sales;
    }

    /**
     * The getter for the name of the branch.
     * @return a String value representing the name of a branch.
     */
    //Setters and getters for Branch
    public String getNameOfBranch() {
        return nameOfBranch;
    }

    /**
     * The setter for the name of the branch.
     * @param nameOfBranch a String value representing the name of the branch.
     */
    public void setNameOfBranch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
    }

    /**
     * A getter for all the sales in a branch.
     * @return an ArrayList of sales that happened in the branch.
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

    /**
     * A setter to change the all sales in a branch.
     * @param sales an ArrayList representing the {@link Branch#sales} done by the branch.
     */
    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    /**
     * A method to add a single sale into the ArrayList of {@link Branch#sales}
     * done in the branch.
     * @param sale a Sale object that represents a house that was sold.
     */
    //Adds a single sale object to the sales ArrayList.
    public void addSale(Sale sale) {
        this.sales.add(sale);
    }

    /**
     * A method that loops through the ArrayList of {@link Branch#sales} in the branch
     * and finds the sale with the highest value.
     * @return an integer that represents the highest sale value in a branch.
     */
    //Finds the highest sale value in a branch
    public int highestSale() {
        int highestSale = 0;

        //Loops through sales
        for (Sale sale : sales) {
            //Checks whether the current sale value is greater than the current highest value.
            if (sale.getValue() > highestSale) {
                highestSale = sale.getValue();
            }
        }
        return highestSale;
    }

    /**
     * A method that loops through the ArrayList of {@link Branch#sales} in the branch
     * and calculates the average sale value among all sales in the branch.
     * @return an integer that represents the average sale value in a branch.
     */
    //Calculates the average sale value
    public int averageSale() {
        int averageSaleTotal = 0;
        int averageSale;
        int count = 0;
        //Loops through the sales ArrayList
        for (Sale sale : sales) {
            //Adds the current sale value to averageSaleTotal
            averageSaleTotal += sale.getValue();
            count += 1;
        }
        //Divides averageSaleTotal by count to get the average sale
        averageSale = averageSaleTotal / count;
        return averageSale;
    }

    /**
     * A method that finds all sales above a given amount by looping through the {@link Branch#sales}
     * ArrayList and then checking whether the current sale value is greater than given amount.
     * @param desiredValue an integer value representing an amount that sale values are meant to be greater than.
     * @return an ArrayList of sales that represents all sales above a given amount.
     */
    //Finds all sales above a certain amount
    public ArrayList<Sale> saleAboveAmount(int desiredValue) {
        //Creates a temporary ArrayList of sales to store all sales greater than the given amount
        ArrayList<Sale> desiredSales = new ArrayList<Sale>();
        //Loops through all sales
        for (Sale sale: sales) {
            //Checks if current sale is greater than the given amount
            if (sale.getValue() > desiredValue) {
                //Adds the sale to the desiredSales ArrayList
                desiredSales.add(sale);
            }
        }
        return desiredSales;
    }

    /**
     * This allows for easier reading of a Branch object.
     * @return a String representing a Branch object.
     */
    @Override
    public String toString() {
        return "Branch{" +
                "nameOfBranch='" + nameOfBranch + '\'' +
                ", sales=" + sales +
                '}';
    }
}

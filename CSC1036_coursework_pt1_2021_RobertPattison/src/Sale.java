/**
 * The Sale class creates a sale object
 * which represents a new sale that is done by an
 * estate agents branch.
 */


public class Sale {

    //Defining all attributes for the class
    private int houseNumber;
    private String postcode;
    private int value;
    private String monthSold;
    private int yearSold;

    /**
     * This is the constructor for the Sale class.
     * @param houseNumber represents a house number for a house.
     * @param postcode represents the postcode of a house.
     * @param value represents how much the house was sold for.
     * @param monthSold represents the month the house was sold.
     * @param yearSold  represents the year the house was sold.
     */
    //Sale class constructor
    public Sale(int houseNumber, String postcode, int value, String monthSold, int yearSold) {
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.value = value;
        this.monthSold = monthSold;
        this.yearSold = yearSold;

    }

    /**
     * The getter for the house number attribute.
     * @return an integer representing house number.
     */
    //All setters and getters for Sale class
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * The setter for the house number attribute.
     * @param houseNumber an integer representing the house number.
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * The getter for the postcode attribute.
     * @return a String representing a postcode for a house.
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * The setter for the postcode attribute.
     * @param postcode a String representing a postcode for a house.
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * The getter for the value of a sold house.
     * @return an integer value representing the value a house was sold for.
     */
    public int getValue() {
        return value;
    }

    /**
     * The setter for the value attribute.
     * @param value an integer value that represents the value a house was sold for.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * The getter for the month a house was sold attribute.
     * @return an String representing when a house was sold.
     */
    public String getMonthSold() {
        return monthSold;
    }

    /**
     * The setter for the monthSold attribute.
     * @param monthSold a String representing the month the house was sold.
     */
    public void setMonthSold(String monthSold) {
        this.monthSold = monthSold;
    }

    /**
     * The getter for the year a house was sold.
     * @return an integer representing when a house was sold.
     */
    public int getYearSold() {
        return yearSold;
    }

    /**
     * The setter for the yearSold attribute.
     * @param yearSold an integer representing the year a house was sold.
     */
    public void setYearSold(int yearSold) {
        this.yearSold = yearSold;
    }

    /**
     * This allows for easier reading of a Sale object.
     * @return a String value representing a Sale object.
     */
    //The modified toString() method allowing easier reading of a Sale object when outputted
    @Override
    public String toString() {
        return "Sale{" +
                "houseNumber=" + houseNumber +
                ", postcode='" + postcode + '\'' +
                ", value=" + value +
                ", monthSold='" + monthSold + '\'' +
                ", yearSold=" + yearSold +
                '}';
    }
}

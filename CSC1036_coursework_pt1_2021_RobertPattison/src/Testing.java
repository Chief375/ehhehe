import java.util.ArrayList;
import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {
        Sale sale1 = new Sale(12,"BF1 2LK",400000, "January", 2012);
        Sale sale2 = new Sale(56,"BF1 9OP",900000, "January", 2012);
        Sale sale3 = new Sale(43,"BF1 5BG",200000, "December", 2012);
        Sale sale4 = new Sale(1,"BF1 2IJ",150000, "March",2012);
        Sale sale5 = new Sale(98,"BF1 1MN",670000, "April",2012);
        Sale sale6 = new Sale(12,"BG1 2LK",700000, "January", 2012);
        Sale sale7 = new Sale(56,"AF1 9OP",850000, "January", 2012);
        Sale sale8 = new Sale(43,"HF1 5BG",1000000, "December", 2012);
        Sale sale9 = new Sale(1,"LF1 2IJ",190000, "March",2012);
        Sale sale10 = new Sale(98,"CF1 1MN",690000, "April",2012);
        Sale sale11 = new Sale(12,"VF1 2LK",980000, "January", 2012);
        Sale sale12 = new Sale(56,"NF1 9OP",560000, "January", 2012);
        Sale sale13 = new Sale(43,"AF1 5BG",780000, "December", 2012);
        Sale sale14 = new Sale(1,"BT1 2IJ",150000, "March",2012);
        Sale sale15 = new Sale(98,"BP1 1MN",900000, "April",2012);
        ArrayList<Sale> tempSales1 = new ArrayList<>(Arrays.asList(sale1, sale2, sale3, sale4, sale5));
        ArrayList<Sale> tempSales2 = new ArrayList<>(Arrays.asList(sale6, sale7, sale8, sale9, sale10));
        ArrayList<Sale> tempSales3 = new ArrayList<>(Arrays.asList(sale11, sale12, sale13, sale14, sale15));
        Branch branch1 = new Branch("Croydon",tempSales1);
        Branch branch2 = new Branch("Shrewsbury",tempSales2);
        Branch branch3 = new Branch("Jersey",tempSales3);

        ArrayList<Branch> tempBranches = new ArrayList<>(Arrays.asList(branch1, branch2, branch3));
        Reporting report = new Reporting(tempBranches);

        System.out.println(report.largestSaleEver());
        System.out.println(report.highestAverageSaleInYear(2012));
        System.out.println(report.salesAboveValue(600000));
        System.out.println(branch1.saleAboveAmount(400000));
        System.out.println(branch1.highestSale());
        System.out.println(branch1.averageSale());
    }
}

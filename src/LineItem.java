import java.util.ArrayList;

public class LineItem {

    // constants
    final static double TAX = .06;

    // static variables
    static int numberOfLineItems = 0;

    // instance variables
    private String itemNumber;
    private int quantity;
    private String description;
    private double price;
    private boolean taxable;

    // constructors
    LineItem (){
        numberOfLineItems++;
    }
    LineItem (String itemNumber, int quantity,
              String description, double price,
              boolean taxable) {
        this.itemNumber = itemNumber;
        this. quantity = quantity;
        this.description = description;
        this.price = price;
        this.taxable = taxable;
        numberOfLineItems++;
    }

    // static methods
    public static double calculateTaxable (ArrayList<LineItem> items) {
        double total = 0;
        for (LineItem item: items) {
            if (item.isTaxable()) {
                total += item.calculatePriceWithTax(item.getPrice(), item.isTaxable());
            }
        }
          return total;
        }
    public static double calculateUntaxable (double grandTotal, double taxable) {
        return grandTotal - taxable;
    }
    public static double calculateTotalPrice (ArrayList<LineItem> items) {
       double totalPrice = 0;
       for (LineItem item: items){
           totalPrice+=item.getPrice();
       }
       return totalPrice;
    }


    public static double calculateTotalTax (double grandTotal, double totalPrice) {
        return grandTotal - totalPrice;
    }

    public static double calculateGrandTotal (double totalPrice, ArrayList<LineItem> items) {
        double taxAmount = 0;
        double grandTotal = 0;
        for (LineItem item: items)
            if (item.isTaxable()) {
            taxAmount+= item.getPrice() * TAX;
            }
        grandTotal = totalPrice + taxAmount;
        return grandTotal;
    }

    // instance methods


    public String getItemNumber() {
        return itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public double calculatePriceWithTax (double price, boolean taxable){
        if (taxable) return price + price * TAX;
        else return price;
    }

    public double calculateTax (double price, boolean taxable){
        if (taxable) return price * TAX;
        else return price;
    }

    @Override
    public String toString (){
        return " " + this.getItemNumber() + " " + this.getQuantity() + " " + this.getDescription() +
                " " + String.format("$%.02f",this.getPrice()) + " " +
                String.format("$%.02f",this.getPrice() * this.getQuantity());
    }
}

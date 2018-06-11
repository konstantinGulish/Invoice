import java.util.ArrayList;
import java.util.Scanner;
public class Invoice {

    public static void main(String[] args) {
        // create array list of line items based on user input
        ArrayList<LineItem> lineItems = new ArrayList<>();

        // create a Scanner for reading user input
        Scanner in = new Scanner(System.in);

        // set a sentinel value
        int numberOfItems;

        // Prompt user to enter the number of items
        System.out.println("How many items do you plan to enter? ");
        numberOfItems = in.nextInt();

        // Prompt the user for item information and sore it in lineItems
        for (int i = 0; i < numberOfItems; i++) {
            LineItem item = new LineItem();
            System.out.println("Enter item number: ");
            item.setItemNumber(in.next());
            in.nextLine();
            System.out.println("Enter item quantity: ");
            item.setQuantity(in.nextInt());
            in.nextLine();
            System.out.println("Enter item description: ");
            item.setDescription(in.nextLine());
            System.out.println("Enter item's price: ");
            item.setPrice(in.nextDouble());
            System.out.println("Is item taxable (y/n): ");
                if (in.next().equalsIgnoreCase("y")){
                    item.setTaxable(true);
                }
                else item.setTaxable(false);
            lineItems.add(item);
        }

        // Output the headings to the screen
        System.out.print("Item ");
        System.out.print("Quantity ");
        System.out.print("Description ");
        System.out.print("Price ");
        System.out.print("Total");
        System.out.println();

        // Output the information for all the items
        for (LineItem item : lineItems) {
            System.out.println(item.toString());
        }
        System.out.println("Taxable subtotal: $" +
                LineItem.calculateTaxable(lineItems));
        System.out.println("Untaxable subtotal: $" +
                LineItem.calculateUntaxable(
                LineItem.calculateGrandTotal(
                        LineItem.calculateTotalPrice(lineItems),lineItems),
                LineItem.calculateTaxable(lineItems)));
        System.out.printf("Tax: $%.2f\n", LineItem.calculateTotalTax(
                LineItem.calculateGrandTotal(LineItem.calculateTotalPrice(lineItems),
                        lineItems),
                LineItem.calculateTotalPrice(lineItems)
        ));
        System.out.println("Grand Total: $" +
                LineItem.calculateGrandTotal(LineItem.calculateTotalPrice(lineItems),
                        lineItems));
    }
}

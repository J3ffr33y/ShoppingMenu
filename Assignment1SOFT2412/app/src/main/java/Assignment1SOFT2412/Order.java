package Assignment1SOFT2412;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Order {

    public Map<Item, Integer> selectedItems = new HashMap<>();
    private double totalCost = 0.0;

    public int selectItemsFromMenu(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            menu.show();
            System.out.println("Enter the item number to add to your order, or 0 to checkout:");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.getItemList().size()) {
                System.out.println("Enter the quantity for the selected item:");
                int quantity = scanner.nextInt();
                addItemToOrder(menu.getItemList().get(choice - 1), quantity);
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        showOrder();
        String confirm = confirmOrder();
        if (confirm.equalsIgnoreCase("c")) {
            //confirm the order
            System.out.println("Your order has been confirmed!");
            return 1;
        } else if (confirm.equalsIgnoreCase("cc")) {
            //cancel the order
            System.out.println("Your order has been cancelled.");
            return 0;
        } else if (confirm.equalsIgnoreCase("b")) {
            //back to main menu
            return -1;

        }
        //default return -1 to go back
        return -1;
    }

    private void addItemToOrder(Item item, int quantity) {
        selectedItems.put(item, selectedItems.getOrDefault(item, 0) + quantity);
        totalCost += item.getPrice() * quantity;
    }

    public void showOrder() {
        System.out.println("Your Order: ");
        String formatStr = "%-15s x %-3d | %-6.2f | %s"; // Adjust the values for your needs
        for (Map.Entry<Item, Integer> entry : selectedItems.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(String.format(formatStr, item.getName(), quantity, item.getPrice() * quantity, item.getDescription()));
        }
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
    }

    public String confirmOrder() {
        boolean result = false;
        String select = "cc";

        while(!result){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Your order detail is listed above, type C to confirm, CC to cancel, or B to back to main menu.");
                select = scan.next();
                if (select.equalsIgnoreCase("c") || select.equalsIgnoreCase("cc") || select.equalsIgnoreCase("b")) {
                    result = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please re-enter.");
                scan.next(); // Clear the invalid input
            }
        }

        return select;

    }

    public void checkOut() {
        boolean result = false;
        String select = "";
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose pickup(P) or delivery(D): ");
            select = scan.next();
            if (select.equalsIgnoreCase("p") || select.equalsIgnoreCase("d")){
                if(select.equalsIgnoreCase("p")){
                    System.out.println("You have successfully chosen pickup service!");
                    result = true;
                } else if(select.equalsIgnoreCase("d")){
                    System.out.println("You have successfully chosen delivery service!");
                    result = true;
                } else {
                    System.out.println("Please type in a valid character(P/D)!\n");
                }
            }
        }
    }
}
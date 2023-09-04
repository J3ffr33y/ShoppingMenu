package Assignment1SOFT2412;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Order {

    private Map<Item, Integer> selectedItems = new HashMap<>();
    private double totalCost = 0.0;

    public void selectItemsFromMenu(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            menu.show();
            System.out.println("Enter the item number to add to your order, or 0 to finish:");
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
    }

    private void addItemToOrder(Item item, int quantity) {
        selectedItems.put(item, selectedItems.getOrDefault(item, 0) + quantity);
        totalCost += item.getPrice() * quantity;
    }

    private void showOrder() {
        System.out.println("Your Order: ");
        String formatStr = "%-15s x %-3d | %-6.2f | %s"; // Adjust the values for your needs
        for (Map.Entry<Item, Integer> entry : selectedItems.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(String.format(formatStr, item.getName(), quantity, item.getPrice() * quantity, item.getDescription()));
        }
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
    }
}
package Assignment1SOFT2412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Menu Original_menu;


    private LoginSystem loginSystem;
    private AdminDashboard adminDashboard;
    private Ask ask;
    private Order currentOrder;

    public void set(){
        Item cola = new CocaCola() ;
        Item sprite = new Sprite();
        Item iceTea = new IceTea();
        Admin admin1 = new Admin("admin1","a");
        Admin admin2 = new Admin("admin2","a");
        Admin admin3 = new Admin("admin3","a");
        List<Item> itemList = new ArrayList<>();
        List<Admin> adminList = new ArrayList<>();
        itemList.add(cola);itemList.add(sprite);itemList.add(iceTea);
        adminList.add(admin1);adminList.add(admin2);adminList.add(admin3);
        Original_menu = new Menu(itemList);
        loginSystem = new LoginSystem(adminList);
        adminDashboard = new AdminDashboard();
        ask = new Ask();

    }
    public void Process(){

        boolean inloop = true;

        while(inloop){
            inloop = false;
            int user_choice = loginSystem.process();
            int orderResult = 0;
            if(user_choice==1){
                boolean adminPass = loginSystem.LogIn();
                if(adminPass){
                    int admin_select = ask.menuShow_or_dashboard();
                    if(admin_select == 1){
//                    need a AdminDashboard show()
                    } else if (admin_select == 2) {
                        Original_menu.show();
                        Order order = new Order();
                        order.selectItemsFromMenu(Original_menu);
                        orderResult = currentOrder.selectItemsFromMenu(Original_menu);
                    } else if (admin_select == 3) {
                        System.out.println("Returning to the main menu.");
                        inloop = true;
                    } else {
                        // need to add a return operation
                        System.out.println("Invalid input!");
                        inloop = true;
                    }
                }
            } else if (user_choice == 2) {
                loginSystem.Registration();
                Original_menu.show();
                if(currentOrder == null) {
                    currentOrder = new Order();
                }
                orderResult = currentOrder.selectItemsFromMenu(Original_menu);
            } else if (user_choice == 3) {
                this.Original_menu.show();
                if(currentOrder == null) {
                    currentOrder = new Order();
                }
                orderResult = currentOrder.selectItemsFromMenu(Original_menu);
            } else if (user_choice == 4) {
                System.out.println("Leading to checkout.......");
                if(currentOrder != null) {
                    currentOrder.showOrder();
                    String confirmResult = currentOrder.confirmOrder();
                    if (confirmResult.equalsIgnoreCase("c")) {
                        System.out.println("Your order has been confirmed!");
                        orderResult = 1;
                    } else if (confirmResult.equalsIgnoreCase("cc")) {
                        System.out.println("Your order has been cancelled.");
                        currentOrder = null; // Reset the currentOrder after cancellation
                    } else if (confirmResult.equalsIgnoreCase("b")) {
                        inloop = true; // Back to the main menu
                    }
                } else {
                    System.out.println("\nNo order to show!");
                }
            } else if (user_choice == 5) {
                System.out.println("Exiting the application. Thank you for using!");
            } else {
                // need to add a return operation
                System.out.println("Invalid option. Please try again! ");
                inloop = true;
            }

            if(orderResult == -1) {
                inloop = true; // If orderResult is -1, loop back to main menu
            } else if(orderResult == 0) {
                currentOrder = null; // If order was cancelled, reset currentOrder
            } else if(orderResult == 1) {
                currentOrder.checkOut();
            }
        }

    }
    public static void main(String[] args) {
        App app = new App();
        app.set();
        app.Process();
    }
}
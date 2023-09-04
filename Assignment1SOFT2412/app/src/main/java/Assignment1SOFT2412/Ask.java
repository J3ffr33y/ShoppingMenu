package Assignment1SOFT2412;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ask {

    public int menuShow_or_dashboard(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Please select the options below: ");
                System.out.println("1. Enter the AdminDashboard");
                System.out.println("2. Enter the Menu");
                System.out.println("3. Back to the previous page");
                select = scan.nextInt();
                if (select == 1 || select == 2 || select == 3) {
                    result = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Clear the invalid input
            }
        }

        return select;
    }
    public int select_menu_item(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("You can ");
            System.out.println("1. enter the AdminDashboard");
            System.out.println("2. enter the Menu");
            System.out.println("3. return");
            select = scan.nextInt();
            if (select == 1||select == 2||select == 3){
                result = true;
            }
        }

        return select;
    }

}

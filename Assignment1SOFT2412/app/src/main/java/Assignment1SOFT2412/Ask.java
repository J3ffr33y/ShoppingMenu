package Assignment1SOFT2412;

import java.util.Scanner;

public class Ask {

    public int menuShow_or_dashboard(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select the options below: ");
            System.out.println("1. enter the AdminDashboard");
            System.out.println("2. enter the Menu");
            select = scan.nextInt();
            if (select == 1||select == 2){
                result = true;
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

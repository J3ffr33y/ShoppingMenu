package Assignment1SOFT2412;

import java.util.Scanner;

public class Ask {
    LoginSystem loginSystem = new LoginSystem();
    String Temporary_name = "";
    String Temporary_password = "";


    public int Initial_query(){
        boolean check = true;
        int result = 0;
        while (check){
            Scanner scan = new Scanner(System.in);
            System.out.println("1. Log in");
            System.out.println("2. Registration ");
            System.out.println("3. User login free");
            result = scan.nextInt();
            if(result == 1 || result == 2 || result == 3){
                check = false;
            }
        }
        return result;
    }

    public boolean LogIn(){
        boolean is_in_list = false;
        String true_password = "";
        boolean result = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter Account: ");
        String enter_account = scan.next();
        Temporary_name = enter_account;
        for(Admin admin : loginSystem.getAdminList()){
            if(admin.getAccount().equals(enter_account)){
                is_in_list = true;
                true_password = admin.getPassword();
                break;
            }
        }
        if(is_in_list){
            while (!result){
                System.out.print("Please enter Password: ");
                String enter_password = scan.next();
                if(enter_password.equals(true_password)){
                    Temporary_password = enter_password;
                    result = true;
                }
            }
        }else{
            System.out.println("Sorry, your account is not on our list!");
        }
        return result;
    }
    public Admin login_ID(){
        Admin a = new Admin(Temporary_name,Temporary_password);
        return a;
    }


    public int Registration1(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose your identity: ");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. return last step");
            select = scan.nextInt();
            if (select == 1||select == 2 || select == 3 ){
                result = true;
            }
        }
        return select;
    }
    public Admin Registration_Admin(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Create an Account: ");
        String new_Account =scan.nextLine();
        System.out.print("Create an Password: ");
        String new_Password =scan.nextLine();
        Admin new_admin = new Admin(new_Account,new_Password);
        return  new_admin;
    }
    public void Registration_User(){
        User new_admin = new User("User","123456");
        System.out.println("Your Account is User");
        System.out.println("Your password is 123456");
    }


    public int menuShow_or_dashboard(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select the options below: ");
            System.out.println("1. enter the AdminDashboard");
            System.out.println("2. enter the Menu");
            System.out.println("3. return last step");
            select = scan.nextInt();
            if (select == 1||select == 2||select == 3){
                result = true;
            }
        }
        return select;
    }
    public int dashboard(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select the options below: ");
            System.out.println("1. Add items to the Menu");
            System.out.println("2. Update the items in Menu");
            System.out.println("3. Delete the items in Menu");
            System.out.println("4. Purchase items");
            select = scan.nextInt();
            if (select == 1||select == 2||select == 3||select == 4){
                result = true;
            }
        }
        return select;
    }
    public Item getNewItem(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your item's name: ");
        String name =scan.nextLine();
        System.out.print("Please enter your item's price: ");
        String enter_price = scan.nextLine();
        double price = Double.parseDouble(enter_price);
        System.out.print("Please enter your item's description: ");
        String description =scan.nextLine();
        Item new_item = new NewItem(name,price,description);
        return new_item;
    }
    public void purchase(ShoppingCart cart,Menu menu){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the line number of the product you want to buy: ");
        int line =scan.nextInt();
        System.out.print("Please enter the number of the product you want to buy: ");
        int number =scan.nextInt();
        int length = menu.getItemList().size();
        for (int i = 0; i < length; i++) {
            if(i + 1 == line){
                cart.add(menu.getItemList().get(i),number);
            }
        }
    }
    public int isPurchase(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to continue buying?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            select = scan.nextInt();
            if (select == 1||select == 2){
                result = true;
            }
        }
        return select;
    }

    public int isDashboard(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to continue operating?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            select = scan.nextInt();
            if (select == 1||select == 2){
                result = true;
            }
        }
        return select;
    }

    public int end(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select the options below:");
            System.out.println("1. Check your all history Order");
            System.out.println("2. End");
            select = scan.nextInt();
            if (select == 1||select == 2){
                result = true;
            }
        }
        return select;
    }
    public String ID(){
        System.out.println("Please enter the ID of you want to check");
        Scanner scann = new Scanner(System.in);
        String id = scann.nextLine();
        return id;
    }
    public int send(){
        boolean result = false;
        int select = 0;
        while(!result){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select the options below:");
            System.out.println("1. Pick it up at the store");
            System.out.println("2. Home delivery");
            select = scan.nextInt();
            if (select == 1||select == 2){
                result = true;
            }
        }
        return select;
    }
}

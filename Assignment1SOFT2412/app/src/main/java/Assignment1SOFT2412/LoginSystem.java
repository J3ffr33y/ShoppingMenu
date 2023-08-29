package Assignment1SOFT2412;

import java.util.List;
import java.util.Scanner;

public class LoginSystem {
    private List<Admin> adminList;

    public LoginSystem(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public List<Admin> getAdminList() {
        return this.adminList;
    }
    public void setPeopleList(List<Admin> adminList) {
        this.adminList = adminList;
    }


    public boolean LogIn(){
        boolean result = false;
        while (!result){
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter Account: ");
            String enter_account = scan.next();
            System.out.print("Please enter Password: ");
            String enter_password = scan.next();
            int size = adminList.size();
            for (int i = 0; i < size; i++) {
                if(enter_account.equals(adminList.get(i).getAccount())){
                    String true_password = adminList.get(i).getPassword();
                    if(true_password.equals(enter_password)){
                        result = true;
                        break;
                    }else{
                        System.out.println("Password is wrong");
                        System.out.println("Please enter again");
                    }
                }
            }
            if(!result){
                System.out.println("Sorry your Account is not in System!");
            }
        }
        return result;
    }
    public void Registration(){
//  The User function needs to be implemented.(Give all users a common account)
        Admin new_admin = new Admin("admin4","123456");
        Scanner scan = new Scanner(System.in);
        System.out.print("Create an Account: ");
        String new_Account =scan.nextLine();
        System.out.print("Create an Password: ");
        String new_Password =scan.nextLine();
        new_admin.setAccount(new_Account);
        new_admin.setPassword(new_Password);
    }

    public int process(){
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
}

package Assignment1SOFT2412;

import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
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
            try {
                FileInputStream fstream = new FileInputStream("src/main/java/Assignment1SOFT2412/Password.csv");
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String temp;
                while ((temp = br.readLine()) != null) {
                    String[] splitted = temp.split(",");
                    if (enter_account.equals(splitted[0])&&enter_password.equals(splitted[1])){
                        System.out.println("Welcome "+splitted[2]+" !");
                        result = true;
                        break;
                    }
                }
                in.close();
            } catch (Exception e) {

                System.err.println(e);
            }


            if(!result){
                System.out.println("Sorry your Account is not in System!");
            }
        }
        return result;
    }
    public void Registration(){
//  The User function needs to be implemented.(Give all users a common account)
        Scanner scan = new Scanner(System.in);
        System.out.print("Create an Account: ");
        String new_Account =scan.nextLine();
        System.out.print("Create an Password: ");
        String new_Password =scan.nextLine();
        try {
            FileWriter fw = new FileWriter("src/main/java/Assignment1SOFT2412/Password.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(new_Account+','+new_Password+','+'N');
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public int process() {
        boolean check = true;
        int result = 0;
        Scanner scan = new Scanner(System.in);
        while (check) {
            try {
                System.out.println("1. Log in");
                System.out.println("2. Registration ");
                System.out.println("3. User login free");
                System.out.println("4. Exit");

                result = scan.nextInt();
                if (result == 1 || result == 2 || result == 3 || result == 4) {
                    check = false;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Clear the invalid input
            }
        }
        return result;
    }
}

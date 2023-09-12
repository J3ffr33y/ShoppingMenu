package Assignment1SOFT2412;

import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Menu {

    private List<Item> itemList;

    public Menu(List<Item> itemList){
        this.itemList = itemList;
    }

    public List<Item> getItemList(){return this.itemList;}
    public boolean containsAKeyword(String myString, String[] keywords){
        for(String keyword : keywords){
            if(myString.contains(keyword)){
                return true;
            }
        }
        return false; // Never found match.
    }
    public void updateItem(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter item name : ");
        String name = console.nextLine();
        System.out.print("What to update?(P for price,D for description,B for both) :");
        String ans = console.nextLine();
        String update = switch (ans) {
            case "P" -> "P";
            case "D" -> "D";
            case "B" -> "B";
            default -> "";
        };
        String[] update_option = {"P","D","B"};
        if(!containsAKeyword(update, update_option)){
            System.out.print("invalid option");
            return;
        }

        System.out.print("Enter the value after update (if you selected B, seperate two updates by ,) :");
        String va = console.nextLine();
        if(update.equals("P")){
            try
            {
                Double.parseDouble(va);
            }
            catch(NumberFormatException e)
            {
                System.out.print("not a number");
                return;
            }
        } else if (update.equals("B")) {
            try
            {
                String[] splitted_check = va.split(",");
                Double.parseDouble(splitted_check[0]);
            }
            catch(Exception e)
            {
                System.out.print("invalid input");
                return;
            }
        }


        try {
            File originalFile = new File("src/main/java/Assignment1SOFT2412/Menu.csv");
            BufferedReader br = new BufferedReader(new FileReader(originalFile));

            // Construct the new file that will later be renamed to the original
            // filename.
            File tempFile = new File("src/main/java/Assignment1SOFT2412/Temp.csv");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            // Read from the original file and write to the new
            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(",");
                if (splitted[0].equals(name)) {
                    if(update.equals("P")){
                        splitted[1] = va;
                    } else if (update.equals("B")) {
                        String[] change = va.split(",");
                        splitted[1] = change[0];
                        splitted[2] = change[1];
                    }
                    else if (update.equals("D")){
                        splitted[2] = va;
                    }
                    line = name+','+splitted[1]+','+splitted[2];
                }
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();
            if (!originalFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(originalFile))
                System.out.println("Could not rename file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void addItem(String name,String price,String desc){
        try {
            FileWriter fw = new FileWriter("src/main/java/Assignment1SOFT2412/Menu.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(name+','+price+','+desc);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void show(){
        /* Alignment needs to be implemented */
        try {
            FileInputStream fstream = new FileInputStream("src/main/java/Assignment1SOFT2412/Menu.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String temp;
            System.out.println(" " + "item names" + " | " + "price" + " | " + "description" + " ");
            System.out.println("------------------------------------------");
            int i = 0;
            while ((temp = br.readLine()) != null) {
                String[] splitted = temp.split(",");
                String item_name = splitted[0];
                String item_description = splitted[1];
                String item_price = splitted[2];
                System.out.println(i + 1 + "." + " " + item_name + " | " + item_price + " | " + item_description + " ");
                System.out.println("-------------------------------------------");
                i += 1;
            }
            in.close();
        } catch (Exception e) {

            System.err.println(e);
        }

    }
}

package Assignment1SOFT2412;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginSystem{
    private List<Admin> adminList = new ArrayList<Admin>(){};
    private String path = "Assignment1SOFT2412/app/src/main/resources/AccountAndPassword.txt";
    public LoginSystem(){
        readTxt();
    }

    public List<Admin> getAdminList() {
        return this.adminList;
    }
    public void setPeopleList(List<Admin> adminList) {
        this.adminList = adminList;
    }
    public void add(Admin admin){
        this.adminList.add(admin);
        writeTxt(this.adminList);
    }

    public void readTxt(){
        try {
            File filename = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine();
                if(line==null){
                    break;
                }else{
                    String[] txtRead = line.split(",");
                    Admin admin = new Admin(txtRead[0],txtRead[1]);
                    adminList.add(admin);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeTxt(List<Admin> iL){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            String first_line = "Account,Password\n";
            out.write(first_line);
            for(Admin i:iL){
                String Account = i.getAccount();
                String Password = i.getPassword();
                String str = String.format("%s,%s",Account,Password);
                str+="\r\n";
                out.write(str);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

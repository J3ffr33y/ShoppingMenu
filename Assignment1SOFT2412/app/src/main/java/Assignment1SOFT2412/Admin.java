package Assignment1SOFT2412;

import java.io.File;
import java.io.IOException;

public class Admin extends People{
    private String Account;
    private String Password;

    public Admin(String account, String password) {
        Account = account;
        Password = password;
    }

    public void setAccount(String account) {
        Account = account;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getAccount(){
        return this.Account;
    }
    public String getPassword(){
        return this.Password;
    }
    public void creatOrderControl() {
        String FileName = this.Account + ".txt";
        String path = "Assignment1SOFT2412/app/src/main/resources" + "\\" + FileName;
        try {
            File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

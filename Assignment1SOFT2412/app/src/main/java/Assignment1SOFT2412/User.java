package Assignment1SOFT2412;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class User extends People{

    private String account;

    private String password ;

    public User(String account,String password){
        this.account =  "User";
        this.password = "123456";
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

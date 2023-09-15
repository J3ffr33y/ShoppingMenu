package Assignment1SOFT2412;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class People{
    String name;
    List<Order> orderList;
    String Account;
    String Password;

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public List<Order> getOrderList() {
        return orderList;
    }
    public String getName(){return this.name;}

}

package Assignment1SOFT2412;

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
}

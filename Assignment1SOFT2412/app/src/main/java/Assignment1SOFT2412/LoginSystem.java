package Assignment1SOFT2412;

import java.util.ArrayList;
import java.util.List;

public class LoginSystem{
    private List<Admin> adminList = new ArrayList<Admin>(){{
        add(new Admin("admin1","a"));
        add(new Admin("admin2","a"));
        add(new Admin("admin3","a"));
    }};

    public List<Admin> getAdminList() {
        return this.adminList;
    }
    public void setPeopleList(List<Admin> adminList) {
        this.adminList = adminList;
    }
    public void add(Admin admin){
        this.adminList.add(admin);
    }

}

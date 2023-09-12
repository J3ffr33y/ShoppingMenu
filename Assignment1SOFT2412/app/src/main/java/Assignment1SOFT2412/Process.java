package Assignment1SOFT2412;
public class Process {
    private Menu menu = new Menu();
    private Ask ask = new Ask();
    private AdminDashboard adminDashboard = new AdminDashboard();
    private ShoppingCart shoppingCart = new ShoppingCart();
    public void process(){
        Admin current_admin = new Admin("current","current");
        User current_user = new User("User","123456");
        boolean finish = false;
        while (!finish){
            int select = 0;
            int Control = 0;
            if(Control == 0){// Initial interface
                select = ask.Initial_query();
                Control = Control+1;
            }
            if(Control == 1){
                if(select == 1){
                    boolean success = ask.LogIn();
                    if(success){
                        Control = Control+1;
                    }else{
                        Control = 0;
                    }
                }
                if(select == 2){
                    int id_select = ask.Registration1();
                    if(id_select == 1){
                        current_admin = ask.Registration_Admin();
                        Control = Control + 2;
                    } else if (id_select == 2) {
                        ask.Registration_User();
                        Control = Control + 2;
                    } else{
                        Control = 0;
                    }
                }
                if (select == 3) {
                    Control = Control + 2;
                }
            }
            if(Control == 2){
                int menu_admin = ask.menuShow_or_dashboard();
                if(menu_admin == 1){
                    int dash_select = ask.dashboard();
                    if(dash_select == 1){
                        Item enter_item = ask.getNewItem();
                        adminDashboard.addItemToMenu(enter_item,menu);
                    } else if (dash_select == 2) {
                        Item enter_item = ask.getNewItem();
                        adminDashboard.updateItem(enter_item,menu);
                    } else if (dash_select == 3) {
                        Item enter_item = ask.getNewItem();
                        adminDashboard.deleteItem(enter_item,menu);
                    }else if (dash_select == 4) {
                        Control = 4;
                    }else{
                        Control = 1;
                    }
                } else if (menu_admin == 2) {
                    Control = Control +1;
                }
            }
            if(Control == 3){
                menu.show();
                Control = Control+1;
            }
            if(Control == 4){
                ask.purchase(shoppingCart,menu);
            }
        }
    }
}

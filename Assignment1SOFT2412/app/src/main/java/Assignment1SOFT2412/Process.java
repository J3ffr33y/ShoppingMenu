package Assignment1SOFT2412;
public class Process {
    private Menu menu = new Menu();
    private Ask ask = new Ask();
    private AdminDashboard adminDashboard = new AdminDashboard();
    private ShoppingCart shoppingCart = new ShoppingCart();
    public void process(){
        Admin current_admin = new Admin("current","current");
        User current_user = new User("User","123456");
        Order order = new Order(shoppingCart);
        OrderList orderList = new OrderList();
        boolean is_admin = false;
        boolean is_sign_in = false;
        boolean finish = false;
        int select = 0;
        int Control = 0;
        while (!finish){
            if(Control == 0){// Initial interface
                select = 0;
                current_admin = new Admin("current","current");
                select = ask.Initial_query();
                Control = 1;
            }
            if(Control == 1){
                if(select == 1){
                    boolean success = ask.LogIn();
                    if(success){
                        current_admin = ask.login_ID();
                        is_admin = true;
                        current_admin.creatOrderControl();
                        Control = Control+1;
                    }else{
                        Control = 0;
                    }
                }
                if(select == 2){
                    int id_select = ask.Registration1();
                    if(id_select == 1){
                        current_admin = ask.Registration_Admin();
                        is_admin = true;
                        current_admin.creatOrderControl();
                        Control = Control + 2;
                    } else if (id_select == 2) {
                        ask.Registration_User();
                        is_sign_in = true;
                        current_user.creatOrderControl();
                        Control = Control + 2;
                    } else{
                        Control = 0;
                    }
                }
                if (select == 3) {
                    Control = Control + 2;
                }
            }
            if(Control == 2){ // Dashboard interface
                int menu_admin = ask.menuShow_or_dashboard();
                if(menu_admin == 1){
                    int dash_select = ask.dashboard();
                    if(dash_select == 1){
                        Item enter_item = ask.getNewItem();
                        adminDashboard.addItemToMenu(enter_item,menu);
                        Control = 6;
                    } else if (dash_select == 2) {
                        Item enter_item = ask.getNewItem();
                        adminDashboard.updateItem(enter_item,menu);
                        Control = 6;
                    } else if (dash_select == 3) {
                        Item enter_item = ask.getNewItem();
                        adminDashboard.deleteItem(enter_item,menu);
                        Control = 6;
                    } else if (dash_select == 4) {
                        Control = 4;
                    }
                } else if (menu_admin == 2) {
                    Control = 3;
                } else{
                    Control = 1;
                }
            }
            if(Control == 3){// Menu show
                menu.show();
                Control = 4;
            }
            if(Control == 4){// buy items
                ask.purchase(shoppingCart,menu);
                Control = 5;
            }
            if(Control == 5){// Repeat purchase
                int isPurchase = ask.isPurchase();
                if(isPurchase == 1){
                    Control = 4;
                }else{
                    Control = 7;
                }
            }
            if(Control == 6){//repeat dashboard
                int s = ask.isDashboard();
                if(s == 1){
                    Control = 2;
                }else{
                    break;
                }
            }
            if(Control == 7){
                if(is_admin){
                    order = new Order(shoppingCart);
                    order.show();
                    orderList = new OrderList(current_admin,order);
                    Control = 8;
                }else{
                    order = new Order(shoppingCart);
                    order.show();
                    if(is_sign_in){
                        orderList = new OrderList(current_user,order);
                        Control = 8;
                    }else{
                        ask.send();
                        break;
                    }
                }
            }
            if(Control == 8){
                int send = ask.send();
                Control = 9;
            }
            if(Control == 9){
                int end = ask.end();
                if(end == 1){
                    String orderId = ask.ID();
                    orderList.checkOrder(orderId);
                }else if(end == 2){
                    break;
                }
            }
        }
    }
}

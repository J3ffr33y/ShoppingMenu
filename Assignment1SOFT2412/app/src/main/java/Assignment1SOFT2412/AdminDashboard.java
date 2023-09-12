package Assignment1SOFT2412;

public class AdminDashboard {

    public void addItemToMenu(Item item,Menu menu){
        menu.add(item);
    }
    public void updateItem(Item item,Menu menu){
        menu.update(item);
    }
    public void deleteItem(Item item,Menu menu){
        menu.delete(item);
    }

}

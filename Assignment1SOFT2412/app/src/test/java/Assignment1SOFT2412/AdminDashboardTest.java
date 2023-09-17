//package Assignment1SOFT2412;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.mockito.Mockito.*;
//
//public class AdminDashboardTest {
//
//    private AdminDashboard dashboard;
//    private Menu mockMenu;
//    private Item mockItem;
//
//    @BeforeEach
//    public void setUp() {
//        dashboard = new AdminDashboard();
//        mockMenu = mock(Menu.class);
//        mockItem = mock(Item.class);
//    }
//
//    @Test
//    public void testAddItemToMenu() {
//        dashboard.addItemToMenu(mockItem, mockMenu);
//        verify(mockMenu, times(1)).add(mockItem);
//    }
//
//    @Test
//    public void testUpdateItem() {
//        dashboard.updateItem(mockItem, mockMenu);
//        verify(mockMenu, times(1)).update(mockItem);
//    }
//
//    @Test
//    public void testDeleteItem() {
//        dashboard.deleteItem(mockItem, mockMenu);
//        verify(mockMenu, times(1)).delete(mockItem);
//    }
//}

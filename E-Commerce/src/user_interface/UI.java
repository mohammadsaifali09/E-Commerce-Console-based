package user_interface;

import buy.CartBuy;
import main.Cart;
import main.User;
import products.Product;
import util.Factory;
import util.Style;
import util.TakingInput;

import java.util.ArrayList;

public class UI
{
    private User user;
    private Style style= Factory.getStyle();

    public void login()
    {
        style.printName(Factory.getShopName());
        user=new User();
        user.setName(TakingInput.takingString("Enter name : ", "(([A-Za-z.\\s]).{2,21}([A-Za-z]$))", "name : ", false));
        user.setMobileNumber(
                TakingInput.takingString("Enter your Mobile number(10digit):+91", "([0-9]).{9}", "mobile number: ", false));
        mainPage();
    }

    public void mainPage()
    {
        String categories[] = { "Electronics", "TVs & Appliances", "Men", "Women", "Books", "View Cart", "Remove Cart" };
        style.printName(Factory.getShopName());
        style.printName(user.getName());
        UICategory ui;
        CartUI cartUI = new CartUI();
        while (true)
        {
            Factory.getStyle().printMenu("CATEGORIES", categories, true);
            int choice = TakingInput.takeChoice(categories.length) - 1;
            switch (choice)
            {
                case 5:
                    cartUI.viewCart();
                    break;
                case 6:
                    cartUI.removeCart();
                    break;
                default:
                    ui = UIFactory.getUI(categories[choice]);
                    ui.category();
                    break;
            }
        }
    }

    public static void printSubCategory(ArrayList<Product> list, String categoryName)
    {
        Style style = Factory.getStyle();
        CartBuy cartBuy = Factory.getCartBuy();
        style.printMenu(categoryName, list);
        int choice = TakingInput.takeChoice(list.size()) - 1;
        cartBuy.add(new Cart(cartBuy.getNextId(), list.get(choice).getName(), list.get(choice).getPrice(),
                TakingInput.takingInt(0, "Enter the Quantity : ", "", "")));
        style.successMsg("Item Added to Cart");
    }
}

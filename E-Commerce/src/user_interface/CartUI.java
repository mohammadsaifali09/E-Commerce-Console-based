package user_interface;

import buy.CartBuy;
import util.Factory;
import util.Style;
import util.TakingInput;

public class CartUI
{
    private CartBuy cartBuy;
    private Style style;

    public CartUI()
    {
        cartBuy= Factory.getCartBuy();
        style=Factory.getStyle();
    }

    public void viewCart()
    {
        if (cartBuy.isEmpty())
        {
            System.out.println("   \u2716 Cart is empty");
        }
        else
        {
            cartBuy.display();
            System.out.println();
            String option = TakingInput.takingString("Do you want to change the quantity? Y/N : ", "[YNyn]", "option",
                    true);
            if (option.equalsIgnoreCase("Y"))
            {
                modify();
            }
        }
    }

    private void modify()
    {
        int index = TakingInput.takingInt(cartBuy.getNextId() - 1, "Enter the SI.No of item to be quantity : ", "Invalid SI.No", "SI.No");
        int quantity = TakingInput.takingInt(0, "Enter the new Quantity : ", "", "");
        cartBuy.changeQuantity(index, quantity);
        style.successMsg("Successfully change");
    }

    public void removeCart()
    {
        if (cartBuy.isEmpty())
        {
            System.out.println("   \u2716 Cart is empty");
        }
        else
        {
            cartBuy.display();
            System.out.println();
            String option = TakingInput.takingString("Do you want to remove range? Y/N : ", "[YNyn]", "option", true);
            if (Character.toUpperCase(option.charAt(0)) == 'Y')
            {
                int[] range = TakingInput.takeRange(cartBuy.getNextId() - 1);
                cartBuy.removeRange(range[0], range[1]);
            }
            else
            {
                int s = TakingInput.takingInt(cartBuy.getNextId() - 1, "Enter the SI.No of item to be remove : ", "Invalid SI.No", "SI.No");
                cartBuy.remove(s);
            }
            style.successMsg("Successfully removed");
        }
    }

    public void viewBill()
    {
        if (cartBuy.isEmpty())
        {
            System.out.println("   \u2716 Cart is empty");
        }
        else
        {
            style.printName(Factory.getShopName());
            style.printDateAndTime();
            cartBuy.displayBill();
        }
        style.thanksMsg();
    }
}

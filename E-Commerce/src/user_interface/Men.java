package user_interface;

import buy.ProductBuy;
import util.Factory;
import util.TakingInput;

public class Men implements UICategory
{

    @Override
    public void category()
    {
        String categories[] = { "T-Shirts", "Shirts", "Suits & Blazers" };
        Factory.getStyle().printMenu("Men", categories, false);
        int choice = TakingInput.takeChoice(categories.length);
        ProductBuy productBuy = Factory.getProductBuy();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBuy.getTshirts(), "T-Shirts");
                break;
            case 2:
                UI.printSubCategory(productBuy.getShirts(), "Shirts");
                break;
            case 3:
                UI.printSubCategory(productBuy.getSuits(), "Suits & Blazers");
                break;
        }
    }
}

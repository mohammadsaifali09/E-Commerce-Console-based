package user_interface;

import buy.ProductBuy;
import util.Factory;
import util.TakingInput;

public class EBooks implements UICategory
{
    @Override
    public void category()
    {
        String categories[] = { "Navels", "Fiction Book", "EBooks" };
        Factory.getStyle().printMenu("Books", categories, false);
        int choice = TakingInput.takeChoice(categories.length);
        ProductBuy productBO = Factory.getProductBuy();
        switch (choice)
        {
            case 1:
                UI.printSubCategory(productBO.getNovelBooks(), "NOVELS");
                break;
            case 2:
                UI.printSubCategory(productBO.getFictionBooks(), "FICTION BOOKS");
                break;
            case 3:
                UI.printSubCategory(productBO.getEBooks(), "EBOOKS");
                break;
        }
    }
}

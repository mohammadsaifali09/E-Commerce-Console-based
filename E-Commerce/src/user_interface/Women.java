package user_interface;

import buy.ProductBuy;
import util.Factory;
import util.TakingInput;

public class Women implements UICategory
{

    @Override
    public void category()
    {
        String categories[] = { "Sarees", "Kurtas & Kurtis", "Lehenga Choli" };
        Factory.getStyle().printMenu("Women", categories, false);
        int choice = TakingInput.takeChoice(categories.length);
        ProductBuy productBuy = Factory.getProductBuy();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBuy.getSareeList(), "Sarees");
                break;
            case 2:
                UI.printSubCategory(productBuy.getKurtas(), "Kurtas & Kurtis");
                break;
            case 3:
                UI.printSubCategory(productBuy.getLc(), "Lehenga Choli");
                break;
        }
    }
}

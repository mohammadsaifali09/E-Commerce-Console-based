package user_interface;

import buy.ProductBuy;
import util.Factory;
import util.TakingInput;

public class Electronics implements UICategory
{
    @Override
    public void category() {
        String categories[] = { "Laptops", "Mobiles", "Headphones", "Camera" };
        Factory.getStyle().printMenu("ELECTRONICS", categories, false);
        int choice = TakingInput.takeChoice(categories.length);
        ProductBuy productBO = Factory.getProductBuy();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBO.getLaptops(), "LAPTOPS");
                break;
            case 2:
                UI.printSubCategory(productBO.getMobiles(), "MOBILES");
                break;
            case 3:
                UI.printSubCategory(productBO.getHeadphones(), "HEADPHONES");
                break;
            case 4:
                UI.printSubCategory(productBO.getCamera(), "CAMERA");
                break;
        }
    }
}

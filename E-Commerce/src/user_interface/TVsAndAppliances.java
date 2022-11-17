package user_interface;

import buy.ProductBuy;
import util.Factory;
import util.TakingInput;

public class TVsAndAppliances implements UICategory
{

    @Override
    public void category()
    {
        String categories[] = { "Television", "Washing Machines", "Refrigerators", "Air Conditioners", "Microwaves" };
        Factory.getStyle().printMenu("HOME APPLIANCES", categories, false);
        int choice = TakingInput.takeChoice(categories.length);
        ProductBuy productBuy = Factory.getProductBuy();
        switch (choice) {
            case 1:
                UI.printSubCategory(productBuy.getTvs(), "Television");
                break;
            case 2:
                UI.printSubCategory(productBuy.getwMachines(), "Washing Machines");
                break;
            case 3:
                UI.printSubCategory(productBuy.getRefrigerator(), "Refrigerators");
                break;
            case 4:
                UI.printSubCategory(productBuy.getAirConditioner(), "Air Conditioners");
                break;
            case 5:
                UI.printSubCategory(productBuy.getMicrowaves(), "Microwaves");
                break;
        }
    }
}

package util;

import buy.CartBuy;
import buy.ProductBuy;

public class Factory
{
    private static Style style=new Style();
    private  static final String shopName="WELCOME TO SHOPPING";
    private static CartBuy cartBuy=new CartBuy();
    private static ProductBuy productBuy=new ProductBuy();

    public static Style getStyle()
    {
        return style;
    }

    public static CartBuy getCartBuy()
    {
        return cartBuy;
    }

    public static ProductBuy getProductBuy()
    {
        return productBuy;
    }

    public static String getShopName()
    {
        return String.format("%-51s",shopName);
    }
}

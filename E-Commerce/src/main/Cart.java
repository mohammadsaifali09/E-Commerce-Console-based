package main;

public class Cart
{
    private int id;
    private String itemName;
    private double price;
    private int quantity;
    private double total;

    public Cart(int id, String itemName, double price, int quantity)
    {
        super();
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.total = price*quantity;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
        total=price*quantity;
    }

    public String getItemName()
    {
        return itemName;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getTotal()
    {
        return total;
    }

    @Override
    public String toString()
    {
        return String.format("\n\u2588    %02d\t    \u2588 %-40s \u2588   %09.2f\t\t    \u2588   %02d\t     \u2588   %09.02f\t\t \u2588",
                id, itemName, price, quantity, total);
    }
}

package main;

public class User
{
    private String name;
    private String mobileNumber;

    public User()
    {
    }

    public User(String name, String mobileNumber)
    {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName()
    {
        return String.format("%-25s",name);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }
}

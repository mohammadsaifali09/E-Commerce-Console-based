package util;

import user_interface.CartUI;

import java.util.Scanner;

public class TakingInput
{
    private static Scanner scanner=new Scanner(System.in);

    public static String takingString(String msg,String regex,String errorMsg,boolean isStyle)
    {
        if (isStyle)
        {
            Factory.getStyle().printStyle(msg);
        }
        else
        {
            System.out.print(msg);
        }
        String s= scanner.nextLine();
        while (!s.matches(regex))
        {
            errorMsg=" 😞😞😞 Sorry invalid !! \n\n   \u21AA Please Retype your " + errorMsg + " : ";
            if (isStyle)
            {
                Factory.getStyle().printStyle(errorMsg);
            }
            else
            {
                System.out.print(errorMsg);
            }
            s= scanner.nextLine();
        }
        return s;
    }

    public static int takingInput(int length,String msg,String errorMsg,String foeWhat)
    {
        System.out.println();
        Factory.getStyle().printStyle(msg);
        int choice=getInt(foeWhat);
        while ((choice>length && choice!=9) || choice==0)
        {
            if (choice==0)
            {
                Factory.getStyle().printStyle("Do you want to bill (Yes/No)?: ");
                if (Character.toUpperCase(scanner.nextLine().charAt(0))=='Y')
                {
                    new CartUI().viewBill();
                }
                System.exit(0);
            }
            printError(errorMsg,foeWhat);
            choice=getInt(foeWhat);
        }
        return choice;
    }

    public static int takeChoice(int length)
    {
        return takingInput(length,"Select choice : ", "Invalid choice", "your choice ");
    }

    public static int takingInt(int length,String msg,String errorMsg,String forWhat)
    {
        System.out.println();
        Factory.getStyle().printStyle(msg);
        int n=getInt(forWhat);
        while (length !=0)
        {
            if (length >=n)
            {
                break;
            }
            printError(errorMsg,forWhat);
            n=getInt(forWhat);
        }
        return n;
    }

    public static int[] takeRange(int range)
    {
        Factory.getStyle().printStyle("Enter the SI.No of item to be remove : ");
        int arr[] ={takingInt(range,"From : ","Invalid SI.No", "SI.No"),
                    takingInt(range,"to : ","Invalid SI.No", "SI.No")};
        return arr;
    }

    private static int getInt(String s)
    {
        while (true)
        {
            try
            {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                printError("Input Only Number",s);
            }
        }
    }

    private static void printError(String error,String forWhat)
    {
        System.out.print("\t😞😞😞 Sorry \u2757\u2757\u2757 " + error + "\n\n   \u21AA Re-enter " + forWhat + ": ");
    }
}

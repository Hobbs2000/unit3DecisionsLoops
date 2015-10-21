import java.util.*;

/**
 * 
 */
public class useYear
{   
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        boolean cont = true;
        while (cont == true)
        {
            System.out.print("Enter a year: ");
            int year = in.nextInt();
            if (Year.isLeapYear(year) == true)
            {
                System.out.println("The year "+year+" is a leap year!");
            }
            else
            {
                System.out.println("The year "+year+" is not a leap year.");
            }
            
            System.out.print("Would you like to enter another year?(y/n): ");
            String again = in.next();
            System.out.println(again);
            if (!(again.equals("y")))
            {
                cont = false;
            }
        }
    }
}
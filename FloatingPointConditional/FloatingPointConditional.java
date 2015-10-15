import java.util.Scanner;

/**
 * 
 */
public class FloatingPointConditional
{
    public final static double EPSILON = 1e-12;
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a floating point number: ");
        double i = input.nextDouble();
        
        String adj = "";
        if (Math.abs(i) < 1.0)
        {
            adj = "Small";
        }        
        else if (Math.abs( i ) > 1000000)
        {
            adj = "Large";
        }
        
        if (Math.abs(i) < EPSILON)
        {
            System.out.println("It's a zero");
        }
        else if ( i > 0)
        {
            System.out.println("Its a"+adj+" positive number.");
        }
        else 
        {
            System.out.println("Its a "+adj+" negative number.");
        }
    }
}

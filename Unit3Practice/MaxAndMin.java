import java.util.Scanner;
/**
 * 
 */
public class MaxAndMin
{
    public static double maximum()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of numbers or any character to stop.");
        double largest = in.nextDouble();
        //Keeps looping until the input is not a double
        while ( in.hasNextDouble() )
        {
            double input = in.nextDouble();
            if (input > largest)
            {
                largest = input;
            }
        }
        
        return largest;
    }
    
    public static double minimum()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of numbers or any character to stop.");
        double smallest = in.nextDouble();
        //Keeps looping until the input is not a double
        while ( in.hasNextDouble() )
        {
            double input = in.nextDouble();
            if (input < smallest)
            {
                smallest = input;
            }
        }
        
        return smallest;
    }
}
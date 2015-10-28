import java.util.*;
/**
 * 
 */
public class CompareAdjacentValues
{
    public static final double EPSILON = 1e-12;
    public static void checkForDuplicates()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enters a serise of numbers or a character to quit.");
        System.out.println("If the number you enter is the same as last input, the program will stop!");
        
        double input = in.nextDouble();
        
        while (in.hasNextDouble())
        {
            double previousInput = input;
            input = in.nextDouble();
            
            //The == would work fine here because there is no operations performed on the doubles
            //But it is better to use this way
            if (Math.abs(input-previousInput) < EPSILON)
            {
                System.out.println("You entered the same number as last time!");
                break;
            }
        }
    }
}
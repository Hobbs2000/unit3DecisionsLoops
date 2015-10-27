import java.util.*;
/**
 * 
 */
public class PromptUntilMatch
{
    public static double promptUntilMatch()
    {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        double input = 0;
        //Use a do while loop becuase the question must be asked at least once
        do 
        {
            System.out.print("Please enter a positive value less than hundred: ");
            input = in.nextDouble();
            if (input > 0 && input < 100)
            {
                valid = true;
            }
        }
        while(!valid);
        
        return input;
    }
}
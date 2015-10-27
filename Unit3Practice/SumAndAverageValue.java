import java.util.Scanner;
/**
 * 
 */
class SumAndAverageValue
{
    public static double averageInputs()
    {
        Scanner in = new Scanner(System.in);
        
        double total = 0;
        int count = 0;
        
        System.out.println("Enter a series of doubles or any character to quit: ");
        
        //Does not know how many times to execute, so use a while loop
        while (in.hasNextDouble())
        {
            double num = in.nextDouble();
            total += num;
            count++;
        }
        double average = 0;
        if (count > 0)
        {
            average = total/count;
        }
        
        return average;
    }
}
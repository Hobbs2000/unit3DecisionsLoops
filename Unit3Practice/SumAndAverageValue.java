import java.util.Scanner;
/**
 * 
 */
class SumAndAverageValue
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        double total = 0;
        int count = 0;
        
        System.out.println("Enter a series of doubles or any character to quit: ");
        
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
            System.out.println("Average: "+average);
        }
    }
}
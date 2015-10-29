/**
 * 
 */
public class NestedLoops
{
    public static void main(String[] args)
    {
        int num1 = 1;
        int num2 = 1;
        
        while (num1 <= 2)
        {
            for (;num2 <= 4;num2++)
            {
                System.out.println(num1+" "+num2);
            }
            num1++;
            num2 = 1;
        }
        
        
        System.out.println("\n\n");
        num1 = 1;
        num2 = 1;
        //Doing the same thing but with only while loops
        while (num1 <= 2)
        {
            while (num2 <= 4)
            {
                System.out.println(num1+" "+num2);
                num2++;
            }
            num1++;
            num2 = 1;
        }
        
        
        System.out.println("\n\n");
        num1 = 1;
        num2 = 1;
        //Do the same thing but with only do loops
        do
        {
            do
            {
                System.out.println(num1+" "+num2);
                num2++;
            }
            while (num2 <= 4);
            num1++;
            num2 = 1;
        }
        while(num1 <= 2);
    }
}
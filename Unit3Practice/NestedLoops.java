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
        
        System.out.println("\n");
        int startNum = 4;
        int max_spaces = startNum-1;
        int lineNum = 1;
        String line = "";
        int amount_add = 0;
        for (;lineNum <= (2*startNum)-1;lineNum+=2)
        {
            line = "";
            for (int i = amount_add; i >= 0; i--)
            {
                line += "*";
            }
            amount_add += 2;
            System.out.println(line);
        }
       lineNum = ((2*startNum)-1)-2;
        int last_line_length = line.length();
        for (;lineNum >= 0;lineNum-=2)
        {
            int num = last_line_length-2;
            for (int i = amount_add; i >= 0; i-=2)
            {   
                if (num <= 0)
                {
                    break;
                } 
                line=line.substring(0,num);
                System.out.println(line);
                num-=2;    
            }
            //System.out.println(line);
            amount_add -= 2;
            if (num <= 0)
            {
                break;
            } 
        }
    }
}
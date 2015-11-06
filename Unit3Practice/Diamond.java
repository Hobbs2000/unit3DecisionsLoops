/**
 * 
 */
public class Diamond 
{
    public static void main(String[] args)
    {
       int startNum = 4;
       int max_spaces = startNum-1;
       int lineNum = 1;
       String line = "";
       int amount_add = 0;
       for (;lineNum <= (2*startNum)-1;lineNum+=2)
       {
           line = "";
           for (int i = max_spaces; i >= 0; i--)
           {
               line += " ";
           }
           for (int i = amount_add; i >= 0; i--)
           {
               line += "*";
           }
           amount_add += 2;
           max_spaces--;
           System.out.println(line);
       }
       lineNum = ((2*startNum)-1)-2;
       int last_line_length = line.length();
       //max_spaces = startNum-1;
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
               System.out.print(line);
               System.out.print("\n");
               num-=2;    
           }
           amount_add -= 2;
           if (num <= 0)
           {
               break;
           } 
       }
    }
}
/**
 * 
 */
public class FindFirstSpaceMatch
{
    public static int findFirstMatch(String str)
    {
        boolean found = false;
        int pos = 0;
        //Does not know how many times to execute, so use a while loop
        while (!found && pos < str.length())
        {
            char ch = str.charAt(pos);
            if (ch == ' ')
            {
                found = true;
            }
            else
            {
                pos++;
            }
        }
        
        if (!found)
        {
            //Returns -1 if there are no spaces in the string
            return -1;
        }
        else
        {
            return pos;
        }
    }
}
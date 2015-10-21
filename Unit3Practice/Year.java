/**
 * @author Calvin Field
 * @version 10/19/15
 */
public class Year
{
    /**
     * 
     */
    public static boolean isLeapYear(int year)
    {
        if ((year % 4 == 0& year % 100 != 0) || year % 400 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
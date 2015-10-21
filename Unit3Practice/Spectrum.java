import java.util.*;
/**
 * 
 */
public class Spectrum
{
    public static void main(String[] args)
    {
        Scanner in =  new Scanner(System.in);
        
        System.out.print("What is the wave length of the wave?: ");
        double waveLength = in.nextDouble();
        
        String type;
        
        if (waveLength < 1e-11)
        {
            type = "Gamma Rays";
        }
        else if (Math.abs(waveLength) >= 1e-11 && Math.abs(waveLength) <= 1e-8)
        {
            type  = "X-rays";
        }
        else if (Math.abs(waveLength) >= 1e-8 && Math.abs(waveLength) <= 4e-7)
        {
            type = "Ultraviolet";
        }
        else if (Math.abs(waveLength) >= 4e-7 && Math.abs(waveLength) <= 7e-7)
        {
            type =  "Visible Light";
        }
        else if(Math.abs(waveLength) >=7e-7 && Math.abs(waveLength) <= 1e-3)
        {
            type = "Infrared";
        }
        else if (Math.abs(waveLength) >= 1e-3 && Math.abs(waveLength) <= 1e-1)
        {
            type = "Microwaves";
        }
        else
        {
            type = "Radio Waves";
        }
        
        System.out.println("The wavelength "+waveLength+" is in the "+type+" part of the electromagnetic spectrum.");
        
    }
}
import java.util.*;
/**
 * 
 */
public class MontyHall
{
    public static void main(String[] args)
    {
        String cont = "y";
        while (cont.equals("y"))
        {
            int car = 0;
            int choice = 0;
            int remainingDoor = 0;
            int hostChoice = 0;
            Random numGen = new Random();
            //Creates a random number between 1-3 and assigns that to car
            car = (numGen.nextInt(3))+1;
            
            Scanner in = new Scanner(System.in);
            System.out.print("Pick a door (1, 2, 3): ");
            choice = in.nextInt();
            
            //Picks a door that is not the car door and not the players choice 
            do 
            {
                hostChoice = (numGen.nextInt(3))+1;
            }
            while(hostChoice == car || hostChoice == choice);
            System.out.println("The host chooses door "+hostChoice+". It has a goat in it!");
            
            //Get the door that hasnt been chosen yet
            do
            {
                remainingDoor = (numGen.nextInt(3))+1;
            }   
            while (remainingDoor == hostChoice || remainingDoor == choice);
        
            System.out.print("Would you like to change yoour choice to door #"+remainingDoor+"?(y/n): ");
            String change = in.next();
            if (change.equals("y"))
            {
                choice = remainingDoor;
            }
            
            if (choice == car)
            {
                System.out.println("You opened the door. Theres a car inside! You won!");
            }
            else 
            {
                System.out.println("You opened the door. There was a goat inside. You lost.");
            }
            
            System.out.print("Would you like to try again?(y/n): ");
            cont = in.next();
        }
    }
}
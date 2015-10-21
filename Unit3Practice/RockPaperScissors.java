import java.util.Scanner;

public class RockPaperScissors
{
     public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2 = scan.next().toLowerCase(); 
        
        if (player1.equals(player2))
        {
            System.out.println("Its a tie!");
        }
        else if (player1.equals("rock") == true && player2.equals("scissors") == true
                || player1.equals("scissors") == true && player2.equals("paper") == true
                || player1.equals("paper") == true && player2.equals("rock") == true)      
        {
            System.out.println("Player 1 wins!");
        }
        else
        {
            System.out.println("Player 2 wins!");
        }
        
    }
}
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber 
{
	static int theNumberYouHaveToGuess;
	int maxRange;
	int move;
	Scanner scanner = new Scanner(System.in);
	
	GuessTheNumber()
	{
		Random random = new Random();
		maxRange = 10;
		theNumberYouHaveToGuess = Math.abs(random.nextInt() % maxRange + 1);
		
		// Why use % (modulo) maxRange + 1?
		/* Well, when you divide any number (x) by another number (y), the remainder (mod) will always be less than the divisor. 
		 * Therefore, it will be a random number from 0 to y, which is what you are looking for. 
		 * You have to include +1 because 0 is considered a number. 
		 * So, if your max is 100, your range is 0 to 99. 
		 * You want it to be 0 to 100 so you add +1.
		 */
	}
	
	public void play()
	{
		while(true)
		{
			int move = scanner.nextInt();
			if(move > theNumberYouHaveToGuess)
			{
				System.out.println("Your guess is too big.");
			}
			else if(move < theNumberYouHaveToGuess)
			{
				System.out.println("Your guess is too small.");
			}
			else
			{
				System.out.println("You guessed the correct number.");
			}
		}
	}
	
	public static void howBigIsTheNumber(int x)
	{
		if(x >= 0 && x <= 5) 
		{
			System.out.println("\nHint: The number seems to be pretty small.");
		}
		else if(x >= 6 && x <= 10) 
		{
			System.out.println("\nHint: The number seems to be a bit bigger.");
		}
		else
		{
			System.out.println("\nHint: The number appears to be out of range!");
		}
	}
		
	public static void main(String[]args)
	{
		GuessTheNumber game = new GuessTheNumber();
		System.out.println("Try and guess the correct number, between 0 and " + game.maxRange + ".");
        	GuessTheNumber.howBigIsTheNumber(theNumberYouHaveToGuess);
        	System.out.println("\nEnter your guess:");
		game.play();
	}
}

import java.util.Random;

public class CoinToss 
{
	public static void main(String[] args)
	{
		CoinToss game = new CoinToss();
		game.tossACoin();
		
		System.out.println(game.tossACoin());
	}
	
	public String tossACoin() 
	{
		Random random = new Random();
		int toss = Math.abs(random.nextInt()) % 2;
		
		if(toss == 0)
		{
			return "HEADS";
		}
		
		else 
		{
			return "TAILS";
		}	
	}
}

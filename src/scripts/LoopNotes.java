public class LoopNotes 
{
	public static void main(String[] args) 
	{
		//Normal Array list
		String[] animals = {"dog", "cat", "mouse", "fox", "kangaroo"};
		
		for(int i=0; i < animals.length; i++) 
		{
			System.out.println(animals[i]);
		}
		
		System.out.println("---------------");
		
		//2D Array list 
		String[][] colors = {{"red", "blue", "green"}, 
							 {"white", "purple", "yellow"}};
		
		for(int row=0; row < 2; row++)
		{
			for(int column=0; column < 3; column++)
			{
				System.out.println(colors[row][column]);
			}
		}
		
		System.out.println("---------------");
		
		//Repetition | Printing out j (0-9) 5 times  
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<10; j++)
			{
				System.out.println("i: " + i + ", j: " + j);
			}
		}
	}
}

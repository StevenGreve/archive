    import java.util.Scanner;
    public class Galgenmaenchen 
    {
        public static void main()
        {
                    String word = WordList.getRandom(WordList.list);
                    Scanner inputReader = new Scanner(System.in);
                    //String input = "";
            
                    //Game instructions
                    System.out.println();
                    System.out.println();
                    System.out.println("From the list of give words there will be one that get's randomly picked. ");
                    System.out.println("Your number of tries equals the length of the word. Use of capital and small initial letters does not matter.");
            
                    System.out.println("Pres j to start the game and press n to end the game");
                    //input = Character.toString((inputReader.next().toLowerCase().charAt(0)));
            
                boolean Continue = true;
                while(Continue)
                {
                    String randomWord = WordList.getRandom(WordList.list);
                    int amountOfguesses = randomWord.length();
                    char[] playersGuess = new char[amountOfguesses];
                    for (int i = 0; i < playersGuess.length; i++)
                    {
                        playersGuess[i] = '_';
                    }
                    boolean wordIsguessed = false;
                    int numberOftries = 0;
                    while(!wordIsguessed && numberOftries != amountOfguesses)
                    {
                        System.out.println("Your current amount of guesses ");
                        PlayerGuessesCount.printArray(playersGuess);
                        Continue = false;
                        System.out.printf("You have %d tries left:%n", amountOfguesses - numberOftries);
                        System.out.println("Enter a single character: ");
                        char input = inputReader.nextLine().charAt(0);
                        numberOftries++;
                    
                        if(input == '-')
                        {
                        Continue = false;
                        wordIsguessed = true;
                        }
                            else 
                            {
                                for(int i = 0; i < randomWord.length();i++)
                                {
                                    if(randomWord.charAt(i) == input)
                                    {
                                        playersGuess[i] = input;
                                    }
                            }
                                if(Did_he_guessed_correct.is_the_word_guessed(playersGuess))
                                {
                                    wordIsguessed = true;
                                    System.out.println("You are victorious");
                                }
                        }
                    }
                                    if(!wordIsguessed)
                                    {
                                        System.out.println("Game Over! ");
                                        System.out.println();
                                        System.out.println("You ran out of guesses");
                                        System.out.println();
                                        System.out.println("_________");
                                        System.out.println("|       |");
                                        System.out.println("|       0");
                                        System.out.println("|      /|\\ ");
                                        System.out.println("|       |  ");
                                        System.out.println("|      / \\ ");
                                        System.out.println("|           ");
                                        System.out.println("|           ");
                                        System.out.println();
                                    }
                                    System.out.println("Continue? (j/n)");
                                    String another_Game = inputReader.nextLine();
                                    if(another_Game.equals("n"))
                                    {
                                        Runtime.getRuntime().halt(0);
                                    }
                                    else
                                    {
                                        main();
                                    }
                }
                 
    }
}

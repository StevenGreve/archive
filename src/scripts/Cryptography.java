import java.util.Scanner;

public class Cryptography 
{
    public static void main(String[] args) 
    {
      // Encryption & Decryption
      String m = "Are ya winning, son?";
      System.out.println(m);
      char[] chars = m.toCharArray();

      for(char c : chars) 
      {
        //c -= 3 for Decryption
        c += 3;
        System.out.print(c);
      }

      //Another way of doing it
      System.out.printf("\n\nEnter your word here: ");
      Scanner input = new Scanner(System.in);
      String text = input.nextLine();

      int length = text.length();
      String result = "";

      for(int i=0; i < length; i++)
      {
        //Returns the character at the specified index in a string
        char character = text.charAt(i);
        character = (char) (character+3);
        result = result + character;
      }
      System.out.println(result);
    }
}

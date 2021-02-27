public class Did_he_guessed_correct
{
    public static boolean is_the_word_guessed (char[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == '_')
            {
                return false;
            }
        }
        return true;
    }
}
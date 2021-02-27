import java.util.Random;

public class WordList
{
    public static String[] list = {"Spargelschaeler", "Laenderspiel", "Schirifehler", "Seitenlinie", "Strafstoss","Kapitaensbinde", "Laolawelle", "Alkoholverbot", 
    "Butterfaesschen", "Obstverwertung", "Elfmeter", "Bachelorarbeit", "Studienabschluss"};
    
    public static String getRandom(String[] list) 
    {
        int random = new Random().nextInt(list.length);
        return list[random];
    }
}


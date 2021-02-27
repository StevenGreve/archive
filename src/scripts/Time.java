import java.util.Timer;
import java.util.TimerTask;
public class Time 
{
   public static void main (String[]args) 
   {
       Timer timer = new Timer();
       timer.schedule(new TimerTask () 
       {
           @Override 
           public void run() 
           {
               System.out.println("Welcome to the King of Iron Fist Tournament 4");
           }
        },10000);
   }
}

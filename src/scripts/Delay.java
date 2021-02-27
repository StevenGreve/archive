 public class Delay
{
   public static void main (String[]args) 
   {
       try
       {
           System.out.println("Initial message...");
           Thread.sleep(1000);
           System.out.println("Delayed message...");
           
       }
       catch(InterruptedException e)
       {
           System.out.println(e.getMessage());
       }
       
   }
}

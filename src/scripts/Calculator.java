public class Calculator 
{
    // region Get-Set Methods
    
    private int[] Numbers;
    
    public int[] GetNumbers()
    {
        return Numbers;
    }
    
    public void SetNumbers(int[] newNumbers)
    {
        Numbers = newNumbers;
    }
    
    // endregion
    
    public Calculator(int[] numbers)
    {
        Numbers = numbers;
    }
    
   // Computes the sum of the constructor's array
    public int Sum() 
    {
        int sum = 0;
        int length = Numbers.length;
        
        for(int number = 0; number < length; number++)
        {
            sum += number;
        }
        
        return sum;
    }
}

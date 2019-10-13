public class PersistentBugger 
{
    public static int persistence(int n) 
    {
        boolean done = false;
        String digits = Integer.toString(n);
        int count = 0;
        int temp = 1;
        
        if(n < 10)
            done = true;

        while(!done)
        {
            temp = 1;   
            for(int i = 0; i < digits.length(); i++)
            {
                temp *= Character.getNumericValue(digits.charAt(i));
            }

            count++;

            if(temp < 10)
                done = true;
            else
            {
                digits = Integer.toString(temp);
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(persistence(33286));
    }
}

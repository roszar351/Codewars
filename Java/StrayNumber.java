public class StrayNumber
{
    public static int stray(int[] numbers)
    {
        int correctNum = numbers[0];
        if(correctNum != numbers[1] && correctNum != numbers[2])
            return correctNum;

        for(int i = 1; i < numbers.length; i++)
            if(correctNum != numbers[i])
                return numbers[i];

        return 0;
    }

    public static void main(String[] args)
    {

    }
}
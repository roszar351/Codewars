public class FindUnique
{
    public static double findUniq(double[] arr)
    {
        double correctNum = arr[0];
        if(correctNum != arr[1] && correctNum != arr[2])
            return correctNum;

        for(int i = 1; i < arr.length; i++)
            if(correctNum != arr[i])
                return arr[i];

        return 0;
    }

    public static void main(String[] args)
    {

    }
}
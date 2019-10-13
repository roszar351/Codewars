public class PlayingWithDigits
{
    public static long digPow(int n, int p)
    {
        p = Integer.toString(n).length() + (p - 1);
        long sum = 0;
        int temp = n;

        while(temp > 0)
        {
            sum += Math.pow(temp % 10, p--);
            temp = temp / 10;
        }

        if(sum % n == 0)
            return sum / n;

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(digPow(89, 1));
        System.out.println(digPow(92, 1));
        System.out.println(digPow(695, 2));
        System.out.println(digPow(46288, 3));
    }
}
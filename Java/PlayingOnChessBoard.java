public class PlayingOnChessBoard
{
    public static String game(long n)
    {
        if(n % 2 == 0)
            return "[" + ((n / 2) * n) + "]";
        else
            return "[" + (n*n) + ", 2]"; 
    }

    public static void main(String[] args)
    {
        System.out.println(game(0));
        System.out.println(game(1));
        System.out.println(game(8));
    }
}
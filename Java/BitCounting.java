public class BitCounting 
{
    public static int countBits(int n)
    {
        String temp = Integer.toBinaryString(n);
        temp = temp.replace("0", "");

		return temp.length();
	}
    
    public static void main(String[] args)
    {

    }
}

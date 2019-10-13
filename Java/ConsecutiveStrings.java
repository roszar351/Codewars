public class ConsecutiveStrings
{
    public static String longestConsec(String[] strarr, int k)
    {
        if(strarr.length == 0 || k > strarr.length || k <= 0)
            return "";

        String ans = "";
        if(strarr.length == k)
            for(int i = 0; i < strarr.length; i++)
                ans += strarr[i];
        else
        {
            boolean stop = false;
            String temp = "";

            for(int i = 0; i < strarr.length && !stop; i++)
            {
                temp = "";
                for(int j = 0; j < k && !stop; j++)
                {
                    if(i + j >= strarr.length)
                        stop = true;
                    else
                        temp += strarr[i+j];
                }

                if(!stop)
                    if(temp.length() > ans.length())
                        ans = temp;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
    }
}
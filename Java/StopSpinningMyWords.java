public class StopSpinningMyWords
{
    public static String spinWords(String sentence)
    {
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++)
            if(words[i].length() >= 5)
                words[i] = new StringBuilder(words[i]).reverse().toString();

        return String.join(" ", words);
    }

    // public static String spinWords(String sentence)
    // {
    //     String[] words = sentence.split(" ");
    //     String ans = "";

    //     for(int i = 0; i < words.length; i++)
    //     {
    //         if(words[i].length() >= 5)
    //             ans += reverseWord(words[i]) + " ";
    //         else
    //             ans += words[i] + " ";
    //     }

    //     return ans.trim();
    // }

    // public static String reverseWord(String s)
    // {
    //     String ans = "";

    //     for(int i = s.length() - 1; i >= 0; i--)
    //         ans += s.charAt(i);

    //     return ans;
    // }

    public static void main(String[] args)
    {

    }
}
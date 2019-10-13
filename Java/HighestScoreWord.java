public class HighestScoreWord
{
    public static String high(String s)
    {
        String[] words = s.split(" ");
        String ans = words[0];
        int highestScore = wordScore(ans);
        int score = 0;

        for(int i = 1; i < words.length; i++)
        {
            score = wordScore(words[i]);

            if(score > highestScore)
            {
                highestScore = score;
                ans = words[i];
            }
        }

        return ans;
    }

    public static int wordScore(String s)
    {
        int score = 0;

        for(int i = 0; i < s.length(); i++)
            score += (int)s.charAt(i) - 96;

        return score;
    }
}
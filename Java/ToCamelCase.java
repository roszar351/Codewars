public class ToCamelCase
{
    public static String toCamelCase(String s)
    {
        String[] words;
        StringBuilder ans = new StringBuilder();

        words = s.split("[-\\_]");

        ans.append(words[0]);
        for(int i = 1; i < words.length; i++)
            ans.append(Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1));

        return ans.toString();
    }
}
import java.util.ArrayList;

public class EnoughIsEnough
{
    public static int[] deleteNth(int[] elements, int maxOccurrences)
    {
        if(maxOccurrences == 0)
            return new int[0];

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i < elements.length; i++)
        {
            if(numbers.contains(elements[i]))
            {
                if(count.get(numbers.indexOf(elements[i])) < maxOccurrences)
                {
                    temp.add(elements[i]);
                    count.set(numbers.indexOf(elements[i]), count.get(numbers.indexOf(elements[i])) + 1);
                }
            }
            else
            {
                temp.add(elements[i]);
                numbers.add(elements[i]);
                count.add(1);
            }
        }

        int[] ans = new int[temp.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = temp.get(i);

        return ans;
    }

    public static void main(String[] args)
    {
    
    }
}
public class WeightForWeight
{
    public static String orderWeight(String strng)
    {
        strng.trim();
        String[] realWeights = strng.split("\\s+");
        int[] newWeights = new int[realWeights.length];

        for(int i = 0; i < realWeights.length; i++)
            newWeights[i] = calcWeight(realWeights[i]);

        boolean swapped;
        String tempStr;
        int tempInt;
        for (int i = 0; i < realWeights.length - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < realWeights.length - i - 1; j++)
            {
                if (newWeights[j] > newWeights[j + 1])
                {
                    tempInt = newWeights[j];
                    newWeights[j] = newWeights[j + 1];
                    newWeights[j + 1] = tempInt;

                    tempStr = realWeights[j];
                    realWeights[j] = realWeights[j + 1];
                    realWeights[j + 1] = tempStr;

                    swapped = true;
                }
                else if(newWeights[j] == newWeights[j + 1])
                {
                    if(realWeights[j].compareTo(realWeights[j + 1]) > 0)
                    {
                        tempInt = newWeights[j];
                        newWeights[j] = newWeights[j + 1];
                        newWeights[j + 1] = tempInt;

                        tempStr = realWeights[j];
                        realWeights[j] = realWeights[j + 1];
                        realWeights[j + 1] = tempStr;

                        swapped = true;
                    }
                }
            }

            if (swapped == false)
                break;
        }

        return String.join(" ", realWeights);
    }

    public static int calcWeight(String s)
    {
        int ans = 0;

        for(int i = 0; i < s.length(); i++)
            ans += Character.getNumericValue(s.charAt(i));

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(calcWeight("5"));
    }
}
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class ParseIntReloaded
{
    private static List<String> singleDigits;
    private static List<String> doubleDigits;
    private static List<String> restDigits;

    public static void main(String[] args)
    {
        System.out.println(parseInt("one-thousand-three-hundred-thirty-seven"));
        System.out.println(parseInt("six hundred fifty-six thousand four hundred ninety-six"));
        System.out.println(parseInt("one thousand three hundred and seven"));
        System.out.println(parseInt("five thousand eight hundred and nine"));
        System.out.println(parseInt("one million"));
    }

    public static int parseInt(String numStr)
    {
        //TODO: change to a map
        initLists();
        numStr = numStr.replaceAll(" and ", " ");
        numStr = numStr.replaceAll("\\s+", "-");
        String[] elements = numStr.split("-");
        int sum = 0;
        int temp = 0;

        for(int i = 0; i < elements.length; ++i)
        {
            int tempInd = restDigits.indexOf(elements[i]);
            // 1000 or 1000000
            if(tempInd == 1 || tempInd == 2)
            {
                temp *= Math.pow(1000, tempInd);
                sum += temp;
                temp = 0;
            }
            else if(tempInd == 0)
            {
                temp *= 100;
            }
            else
            {
                if(singleDigits.contains(elements[i]))
                {
                    temp += singleDigits.indexOf(elements[i]);
                }
                else
                {
                    tempInd = doubleDigits.indexOf(elements[i]);
                    if(tempInd < 11)
                        temp += tempInd + 10;
                    else
                        temp += (tempInd % 10) * 10 + 20;
                }
            }
        }

        sum += temp;
        return sum;
    }

    public static void initLists()
    {
        if(singleDigits != null)
            return;

        singleDigits = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        doubleDigits = Arrays.asList("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");
        restDigits = Arrays.asList("hundred", "thousand", "million");
    }
}
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class SimpleAssembler
{
    public static Map<String, Integer> interpret(String[] program)
    {
        Map<String, Integer> ans = new HashMap<String, Integer>();
        String[] commandElements;
        String stringValue = "";

        for(int i = 0; i < program.length; i++)
        {
            commandElements = program[i].split(" ");

            switch(commandElements[0])
            {
                case "mov":
                    stringValue = commandElements[2];

                    if(stringValue.matches("-?\\d+"))
                        ans.put(commandElements[1], Integer.parseInt(commandElements[2]));
                    else
                        ans.put(commandElements[1], ans.get(stringValue));

                    break;
                case "inc":
                    ans.put(commandElements[1], ans.get(commandElements[1]) + 1);
                    break;
                case "dec":
                    ans.put(commandElements[1], ans.get(commandElements[1]) - 1);
                    break;
                case "jnz":
                    stringValue = commandElements[1];

                    if(stringValue.matches("-?\\d+"))
                    {
                        if(Integer.parseInt(stringValue) != 0)
                            i = (i-1) + Integer.parseInt(commandElements[2]);
                    }
                    else
                    {
                        if(ans.get(commandElements[1]) != 0)
                            i = (i-1) + Integer.parseInt(commandElements[2]);
                    }
                    break;
                default:
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {

    }
}
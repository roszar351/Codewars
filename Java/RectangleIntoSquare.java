import java.util.*;

public class RectangleIntoSquare
{
    public static List<Integer> sqInRect(int lng, int wdth)
    {
        if(lng == wdth)
            return null;
            
        List<Integer> ans = new ArrayList<Integer>();
        int area = lng * wdth;

        while(area > 0)
        {
            if(lng < wdth)
            {
                ans.add(lng);
                area -= lng * lng;
                wdth -= lng;
            }
            else
            {
                ans.add(wdth);
                area -= wdth * wdth;
                lng -= wdth;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(sqInRect(3, 5));
    }
}
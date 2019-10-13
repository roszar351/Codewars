public class Snail
{
    /*
     *  n x n array
     * 
     *  1 1 1   1 1 1 1     1 1 1 1 1
     *  1 1 1   1 1 1 1     1 1 1 1 1
     *  1 1 1   1 1 1 1     1 1 1 1 1
     *          1 1 1 1     1 1 1 1 1
     *                      1 1 1 1 1
     * 
     */
    public static int[] snail(int[][] array)
    {
        int n = array.length;
        if(array[0].length == 0)
            return new int[0];

        int minR, maxR, minC, maxC, r, c, i;
        minR = minC = r = c = i = 0;
        maxR = maxC = n - 1;
        int[] ans = new int[n * n];
        char direction = 'R'; // U, D, L, R -> starts going right i.e. 'R'

        while(i < ans.length)
        {
            switch(direction)
            {
                case 'U':
                    for(r = maxR, c = minC; r >= minR; r--, i++)
                        ans[i] = array[r][c];

                    direction = 'R';
                    minC++;
                    break;
                case 'D':
                    for(r = minR, c = maxC; r <= maxR; r++, i++)
                        ans[i] = array[r][c];

                    direction = 'L';
                    maxC--;
                    break;
                case 'L':
                    for(r = maxR, c = maxC; c >= minC; c--, i++)
                        ans[i] = array[r][c];

                    direction = 'U';
                    maxR--;
                    break;
                case 'R':
                    for(r = minR, c = minC; c <= maxC; c++, i++)
                        ans[i] = array[r][c];

                    direction = 'D';
                    minR++;
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] temp = snail(new int[0][0]);
        for(int i = 0; i < temp.length; i++)
            System.out.print(temp[i] + ", ");
    }
}
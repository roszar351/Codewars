import java.util.ArrayList;

public class SudokuValidator
{
    public static boolean check(int[][] sudoku)
    {
        ArrayList<Integer> alreadyThere1 = new ArrayList<>();
        ArrayList<Integer> alreadyThere2 = new ArrayList<>();
  		
  		for(int i = 0; i < sudoku.length; i++)
  		{
  			for(int j = 0; j < sudoku[0].length; j++)
  			{
  				if(alreadyThere1.contains(sudoku[i][j]) || alreadyThere2.contains(sudoku[j][i]) || sudoku[i][j] == 0 || sudoku[j][i] == 0)
  					return false;
  				
                alreadyThere1.add(sudoku[i][j]);
                alreadyThere2.add(sudoku[j][i]);
  			}
  			
  			alreadyThere1.clear();
  			alreadyThere2.clear();
  		}

  		ArrayList<Integer> alreadyThere3 = new ArrayList<>();
  		
  		for(int i = 0; i < sudoku.length; i++)
  		{
  			if(i == 3 || i == 6)
  			{
  				alreadyThere1.clear();
  				alreadyThere2.clear();
  				alreadyThere3.clear();
  			}
  			
  			for(int j = 0; j < sudoku[i].length; j++)
  			{
  				if(j < 3)
  				{
  					if(alreadyThere1.contains(sudoku[i][j]))
  						return false;
  					
  					alreadyThere1.add(sudoku[i][j]);
  				}
  				else if(j < 6)
  				{
  					if(alreadyThere2.contains(sudoku[i][j]))
  						return false;
  					
  					alreadyThere2.add(sudoku[i][j]);
  				}
  				else
  				{
  					if(alreadyThere3.contains(sudoku[i][j]))
  						return false;
  					
  					alreadyThere3.add(sudoku[i][j]);
  				}
  			}
  		}
  		return true;
    }
}
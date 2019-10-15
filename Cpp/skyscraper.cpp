#include <vector>
#include <iostream>
#include <chrono>

using namespace std::chrono; 

void showBoard();

int result[4][4] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

void clearResultArray()
{
    for(int i = 0; i < 4; i++)
    {
        for(int j = 0; j < 4; j++)
        {
            result[i][j] = 0;
        }
    }
}

bool checkBothClues(int left, int right, int* rowOrCol)
{
    int seen = 1;
    int largest = rowOrCol[0];
    
    if(left != 0)
    {
        for(unsigned int i = 1; largest != 4; i++)
        {
            if(seen > left)
            {
                return false;
            }

            if(rowOrCol[i] > largest)
            {
                largest = rowOrCol[i];
                seen++;
            }
        }

        if(seen != left)
        {
            return false;
        }
    }

    if(right == 0)
        return true;

    seen = 1;
    largest = rowOrCol[3];

    for(int i = 2; largest != 4; i--)
    {
        if(rowOrCol[i] == 0 || largest == 0)
            return true;

        if(seen > right)
        {
            return false;
        }

        if(rowOrCol[i] > largest)
        {
            largest = rowOrCol[i];
            seen++;
        }
    }

    if(seen != right)
    {
        return false;
    }

    return true;
}

bool isBoardValid(int* clues)
{
    int count = 0;
    // check horizontally
    for(unsigned int i = 0; i < 4; i++)
    {
        bool checks[4] = {0, 0, 0, 0};
        int row[4] = {0, 0, 0, 0};
        for(unsigned int j = 0; j < 4; j++)
        {
            int temp = result[i][j];
            if(temp)
            {
                if(!checks[temp - 1])
                {
                    checks[temp - 1] = true;
                    row[j] = temp;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
            
        }

        if(!checkBothClues(clues[15 - i], clues[4 + i], row))
            return false;
    }

    // check vertically
    for(unsigned int i = 0; i < 4; i++)
    {
        bool checks[4] = {0, 0, 0, 0};
        int col[4] = {0, 0, 0, 0};
        for(unsigned int j = 0; j < 4; j++)
        {
            int temp = result[j][i];
            if(temp)
            {
                if(!checks[temp - 1])
                {
                    checks[temp - 1] = true;
                    col[j] = temp;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
        }

        if(!checkBothClues(clues[0 + i], clues[11 - i], col))
            return false;
    }

    return true;
}

int** SolvePuzzle(int* clues)
{
    clearResultArray();
    int i = 0;
    int j = 0;
    bool done = false;

    for(; i < 4; i++)
    {
        if(done)
            done = false;
        else
            j = 0;
        
        for(; j < 4 && !done; j++)
        {
            result[i][j] = result[i][j] + 1;

            if(result[i][j] > 4)
            {
                result[i][j] = 0;
                j -= 2;
                if(j <= -2)
                {
                    i -= 2;
                    j = 2;
                    done = true;
                }
            }
            else if(!(isBoardValid(clues)))
            {
                if(result[i][j] > 4)
                {
                    result[i][j] = 0;
                    j -= 2;
                    if(j <= -2)
                    {
                        i -= 2;
                        j = 2;
                        done = true;
                    }
                }
                else
                {
                    j--;
                }
            }
        }
    }

    int** ans = new int*[4];
    for(unsigned int i = 0; i < 4; i++)
        ans[i] = result[i];

    return ans;
}

void showBoard()
{
    for(unsigned int i = 0; i < 4; i++)
    {
        for(unsigned int j = 0; j < 4; j++)
        {
            std::cout << result[i][j] << ", ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}

int main()
{
    int clues[][16] = {
                      { 2, 2, 1, 3,  
                        2, 2, 3, 1,  
                        1, 2, 2, 3,  
                        3, 2, 1, 3 },
                      { 0, 0, 1, 2,   
                        0, 2, 0, 0,   
                        0, 3, 0, 0, 
                        0, 1, 0, 0 },
                      };
    
    auto start = high_resolution_clock::now(); 
    SolvePuzzle(clues[0]);
    auto stop = high_resolution_clock::now();

    showBoard();
    auto duration = duration_cast<milliseconds>(stop - start); 
  
    std::cout << "Time taken by function: "
         << duration.count() << " milliseconds" << std::endl; 

    return 0;
}

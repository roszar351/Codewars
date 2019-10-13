#include <string>
#include <vector>
#include <iostream>

/*
 * Tower:       level:    No. of '*':
 *      *         0           1
 *     ***        1           3
 *    *****       2           5
 *   *******      3           7
 */
std::vector<std::string> towerBuilder(int nFloors)
    {
        std::vector<std::string> ans;
        std::string currentLevel;
        int j = 0;

        for(int i = 0; i < nFloors; i++)
        {
            currentLevel = "";
            j = i + 1;
            while(j - nFloors != 0)
            {
                currentLevel += " ";
                j++;
            }

            j = i * 2 + 1;
            for(int x = 0; x < j; x++)
                currentLevel += "*";
                
            j = i + 1;
            while(j - nFloors != 0)
            {
                currentLevel += " ";
                j++;
            }
            
            ans.push_back(currentLevel); 
        }

        return ans;
    }

int main()
{
    std::vector<std::string> tower = towerBuilder(5);
    for(int i = 0; i < tower.size(); i++)
    {
        std::cout << tower.at(i) << std::endl;
    }

    return 0;
}

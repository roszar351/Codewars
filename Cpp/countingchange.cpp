#include <vector>
#include <iostream>

unsigned long long countChange(const unsigned int money, const std::vector<unsigned int>& coins) 
{
    std::vector<unsigned long long> table;
    table.resize(money + 1);
    table[0] = 1;

    for(unsigned int i = 0; i < coins.size(); i++)
        for(unsigned int j = coins[i]; j <= money; j++)
            table[j] += table[j - coins[i]];

    return table[money];
}

int main()
{
    std::cout << countChange(4, {1, 2}) << std::endl;
    std::cout << countChange(10, {5, 2, 3}) << std::endl;

    return 0;
}

#include <iostream>
#include <string>

std::string solution(int number)
{
    std::string ans;
    std::string M[] = {"","M","MM","MMM"};
    std::string C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    std::string X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    std::string I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    ans = M[number/1000]+C[(number%1000)/100]+X[(number%100)/10]+I[(number%10)];

    return ans;
}

int main()
{
    std::cout << solution(8) << std::endl;
    std::cout << solution(182) << std::endl;
    std::cout << solution(1990) << std::endl;
    std::cout << solution(1875) << std::endl;

    return 0;
}

#include <vector>
#include <iostream>

typedef unsigned long long ull;

static std::vector<ull> productFib(ull prod)
{
    std::vector<ull> ans;
    ans.push_back(0);
    ans.push_back(1);
    ans.push_back(1);

    // 0, 1, 1, 2, 3, 5

    while(ans[0] * ans[1] < prod)
    {
        ans[2] = ans[0] + ans[1];
        ans[0] = ans[1];
        ans[1] = ans[2];
    }

    if(ans[0] * ans[1] == prod)
        ans[2] = 1;
    else
        ans[2] = 0;    

    return ans;
}

int main()
{
    std::vector<ull> test = productFib(714);
    std::cout << test.at(0) << ", " << test.at(1) << ", " << test.at(2) << std::endl;

    test = productFib(800);
    std::cout << test.at(0) << ", " << test.at(1) << ", " << test.at(2) << std::endl;

    return 0;
}

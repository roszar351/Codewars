#include <iostream>
#include <math.h>

long zeros(long n)
{
    // log base 5 of number n
    long k = (long)(log2(n) / log2(5));
    long ans = 0;

    for(long i = 1; i <= k; i++)
        ans += (long)(n / (pow(2, i)));

    return ans;
}

int main()
{
    std::cout << zeros(0) << std::endl;
    std::cout << zeros(6) << std::endl;
    std::cout << zeros(30) << std::endl;
    std::cout << zeros(100) << std::endl;

    return 0;
}

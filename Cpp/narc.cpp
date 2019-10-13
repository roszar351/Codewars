#include <iostream>
#include <math.h>

/*
 * Exponentiation by squaring for positive integers
 */
int myIntPow(int x, int y)
{
    if(y == 0)
        return 1;
    else if(y == 1)
        return x;
    else if(y % 2 == 0)
        return myIntPow(x * x, y / 2);
    else
        return x * myIntPow(x * x, (y - 1) / 2);    
}

bool narcissistic( int value )
{
    int n = value;
    int digits = 0, sum = 0, temp = 0;

    while(n)
    {
        n = n / 10;
        digits++;
    }

    n = value;
    while(n)
    {
        temp = n % 10;
        n = n / 10;
        sum += myIntPow(temp, digits);
    }

    return (sum == value);
}

int main()
{
    std::cout << narcissistic(153) << std::endl;
    std::cout << narcissistic(1634) << std::endl;
    std::cout << narcissistic(9999) << std::endl;

    return 0;
}
#include <vector>
#include <math.h>
#include <iostream>
#include <algorithm>

void printVecor(std::vector<long long> v)
{
    for(int i = 0; i < v.size(); i++)
        std::cout << v[i] << ", ";

    std::cout << std::endl;
}

class KPrimes
{
public:
    static std::vector<long long> countKprimes(int k, long long start, long long end)
    {
        std::vector<long long> kPrimes;

        for(; start <= end; start++)
            if(enoughPrimeFactors(start, k))
                kPrimes.push_back(start);

        return kPrimes;
    }
    
    static int puzzle(int s)
    {
        std::vector<long long> onePrimes = countKprimes(1, 0, s);
        std::vector<long long> twoPrimes = countKprimes(3, 0, s);
        std::vector<long long> threePrimes = countKprimes(7, 0, s);
        int count = 0;

        for(int i = 0; i < onePrimes.size(); i++)
        {
            long long sum = 0;
            for(int j = 0; j < twoPrimes.size(); j++)
            {
                bool done = false;
                sum = onePrimes[i] + twoPrimes[j];
                if(sum < s)
                {
                    for(int x = 0; x < threePrimes.size() && !done; x++)
                    {
                        if(sum + threePrimes[x] == s)
                        {
                            count++;
                            done = true;
                        }
                        if(sum + threePrimes[x] > s)
                            done = true;
                    }
                }
                else
                    j = twoPrimes.size();
            }
        }

        return count;
    }

private:
    static bool enoughPrimeFactors(long long num, int limit)
    {
        if(num < 2)
            return 0;

        int count = 0;

        while(num % 2 == 0)
        {
            count++;
            num = num / 2;
        }

        for(long long i = 3; i <= sqrt(num); i += 2)
        {
            if(count > limit)
                return 0;

            while(num % i == 0)
            {
                count++;
                num = num / i;
            }
        }

        if(num > 2)
            count++;

        return count == limit;
    }
};

bool dotest(int k, long long start, long long nd, std::vector<long long> expected)
{
    std::vector<long long> t = KPrimes::countKprimes(k, start, nd);
    
    if(t.size() != expected.size())
        return false;
    for(int i = 0; i < t.size(); i++)
        if(t[i] != expected[i])
            return false;

    return true;
}

int main()
{
    std::vector<long long> sol = {4,6,9,10,14,15,21,22,25,26,33,34,35,38,39,46,49,51,55,57,58,62,65,69,74,77,82,85,86,87,91,93,94,95};
    std::cout << dotest(2, 0, 100, sol) << std::endl;
    sol =  {8, 12, 18, 20, 27, 28, 30, 42, 44, 45, 50, 52, 63, 66, 68, 70, 75, 76, 78, 92, 98, 99};
    std::cout << dotest(3, 0, 100, sol) << std::endl;
    std::cout << "Puzzle " << KPrimes::puzzle(138) << std::endl;
    std::cout << "Puzzle " << KPrimes::puzzle(143) << std::endl;
    std::cout << "Puzzle " << KPrimes::puzzle(250) << std::endl;
    return 0;
}

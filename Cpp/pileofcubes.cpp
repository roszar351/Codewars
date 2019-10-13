#include <iostream>

using namespace std;

static long long findNb(long long m)
{
    long long sum = 0;
    long long ans = 1;

    while(sum < m)
    {
        sum += ans * ans * ans;
        ans++;
    }

    if(sum == m)
        return (ans - 1);
    
    return -1;
}

int main()
{
    cout << findNb(4183059834009) << endl;
    cout << findNb(24723578342962) << endl;
    cout << findNb(135440716410000) << endl;
    cout << findNb(40539911473216) << endl;
    cout << findNb(26825883955641) << endl;

    return 0;
}

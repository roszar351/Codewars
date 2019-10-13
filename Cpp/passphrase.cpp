#include <iostream>
#include <string>

static std::string playPass(const std::string &s, int n)
{
    std::string temp;

    for(int i = 0; i < s.size(); i++)
    {
        char ch = s.at(i);
        if(isdigit(ch))
        {
            temp += ('9' - (ch - '0'));
        }
        else if(isalpha(ch))
        {
            if(ch > 97)
            {
                ch = (ch + n - 97) % 26 + 97;
            }
            else
            {
                ch = (ch + n - 65) % 26 + 65;
            }
            
            if(i % 2 == 0)
            {
                ch = toupper(ch);
            }
            else
            {
                ch = tolower(ch);
            }

            temp += ch;
        }
        else
        {
            temp += ch;
        }
        
    }

    std::string ans;
    for(int i = temp.size() - 1; i >= 0; i--)
    {
        ans += temp.at(i);
    }

    return ans;
}

int main()
{
    std::cout << playPass("Z Love", 1);

    return 0;
}

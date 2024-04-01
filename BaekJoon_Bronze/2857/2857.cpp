#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

int main()
{
    string n;
    int order = 1;
    vector<int> result;
    for (int i = 0; i < 5; i++)
    {
        cin >> n;
        if (n.find("FBI") != string::npos)
        {
            int flag = 0;
            for (int i = 0; i < n.size(); i++)
            {
                if ((n[i] <= 90 && n[i] >= 65) || n[i] == 45 || (n[i] <= 57 && n[i] >= 48))
                {
                    flag = 0;
                }
                else
                {
                    flag = 1;
                }
            }

            if (flag == 0)
            {
                result.push_back(order);
            }
        }
        order++;
    }

    if (result.size() == 0)
    {
        cout << "HE GOT AWAY!";
        return 0;
    }

    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << " ";
    }
}
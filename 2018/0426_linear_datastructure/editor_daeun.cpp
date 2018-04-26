#include <iostream>
#include <list>
#include <string>

using namespace std;

list<char> str;

int main()
{
	string s;
	cin >> s;
	for (int i = 0; i < s.size(); i++)
	{
		str.push_back(s[i]);
	}
	list<char>::iterator iter = str.end();
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		char cmd;
		cin >> cmd;
		if (cmd == 'L' && iter != str.begin())
		{
			--iter;
		}
		if (cmd == 'D' && iter != str.end())
		{
			++iter;
		}
		if (cmd == 'B' && iter != str.begin())
		{
			--iter;
			iter = str.erase(iter);
		}
		if (cmd == 'P')
		{
			char ch;
			cin >> ch;
			str.insert(iter, ch);
			int a = 0;
		}
	}
	for (list<char>::iterator iter = str.begin(); iter != str.end(); ++iter)
	{
		cout << *iter;
	}
	return 0;
}
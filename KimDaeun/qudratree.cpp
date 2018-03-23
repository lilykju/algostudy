#include <iostream>
#include <string>

using namespace std;
int getDivideLen(string str)
{
	string::iterator iter = str.begin();
	if ((*iter) != 'x') return 1;
	//iter++;
	iter = str.erase(iter);
	int len = 1;
	int count = 0;
	for(int i=0;i<4;i++)
	{
		if ((*iter) != 'x')
		{
			len++;
			iter = str.erase(iter);
		}
		else
		{
			int temp = getDivideLen(str);
			iter += temp;
			len += temp;
		}
	}
	return len;
}
string reverseTree(string str)
{
	string::iterator iter = str.begin();
	string beforeReversed[4];
	string reversed[4];
	if ((*iter) != 'x')
	{
		return str;
	}
	//iter++;
	iter = str.erase(iter);
	int count = 0;
	int idx = 0;
	//divide
	int len[4] = { 0,0,0,0 };
	len[0] = getDivideLen(str);
	beforeReversed[0] = str.substr(0,len[0]);
	for (int i = 0; i < 3; i++)
	{
		str = str.substr(len[i]);
		len[i + 1] = getDivideLen(str);
		beforeReversed[i + 1] = str.substr(0, len[i + 1] );
	}
	

	reversed[0] = reverseTree(beforeReversed[2]);
	reversed[1] = reverseTree(beforeReversed[3]);
	reversed[2] = reverseTree(beforeReversed[0]);
	reversed[3] = reverseTree(beforeReversed[1]);
	return "x" + reversed[0] + reversed[1] + reversed[2] + reversed[3];
}
int main()
{
	int t;
	cin >> t;
	string str;
	for (int i = 0; i < t; i++)
	{
		cin >> str;
		string result = reverseTree(str);
		cout << result<<endl;
	}
}
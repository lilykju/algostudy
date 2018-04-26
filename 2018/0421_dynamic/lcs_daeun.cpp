#include <iostream>
#include <string>
#include <cstring>

using namespace std;
string a;
string b;
int lcs[1000][1000];

int main()
{
	
	cin >> a;
	cin >> b;
	memset(lcs, 0, sizeof(lcs));
	for (int i = 1; i < a.length()+1; i++)
	{
		for (int j = 1; j < b.length()+1; j++)
		{
			if (a[i-1] == b[j-1]) lcs[i][j] = lcs[i - 1][j - 1] + 1;
			else
			{
				lcs[i][j] = lcs[i - 1][j];
				if (lcs[i][j] < lcs[i][j - 1]) lcs[i][j] = lcs[i][j - 1];
			}
		}
	}
	cout << lcs[a.length()][b.length()] << endl;
	return 0;
}
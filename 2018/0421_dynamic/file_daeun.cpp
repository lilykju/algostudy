#include <iostream>
#include <vector>
#include <cstring>
#include <string>

using namespace std;

vector<int> chap;
int cache[500][500];

int sum(int from, int to);
int merge(int from, int to);

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int b;
		cin >> b;
		//cache √ ±‚»≠
		memset(cache, 0, sizeof(cache));
		for (int j = 0; j < b; j++)
		{
			int ch;
			cin >> ch;
			chap.push_back(ch);
			cache[j][j] = ch;
		}
		cout << merge(0, b - 1) << endl;
		chap.clear();
	}
	return 0;
}

int sum(int from, int to)
{
	int sum = 0;
	for (int i = from; i <= to; i++)
	{
		sum += chap[i];
	}
	return sum;
}

int merge(int from, int to)
{
	if (from == to) return cache[from][to];
	if (cache[from][to] != 0) return cache[from][to];
	//if (abs(from - to) == 1)
	//{
	//	cache[from][to] = chap[from] + chap[to];
	//	return cache[from][to];
	//}
	int min = 10000000;
	for (int i = from; i < to; i++)
	{
		int temp = sum(from, to);
		if (from != i)
		{
			if(cache[from][i]==0) cache[from][i]= merge(from, i);
			temp += cache[from][i];
		}
		if ((i + 1) != to)
		{
			if (cache[i+1][to] == 0) cache[i+1][to] = merge(i+1, to);
			temp += cache[i + 1][to];
		}
		if (min > temp) min = temp;
	}
	return min;
//	cache[from][to] = min;
//	return cache[from][to];
}


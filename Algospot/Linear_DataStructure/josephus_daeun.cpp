#include <iostream>
#include <list>

using namespace std;

int main()
{
	int c;
	cin >> c;
	for (int i = 0; i < c; i++)
	{
		int n, k;
		cin >> n;
		cin >> k;
		//list initialize
		list<int> soldiers;
		for (int j = 0; j < n; j++)
		{
			soldiers.push_back((j - k + 1+n) % n);	//0부터 초기화
		}
		list<int>::iterator iter = soldiers.begin();
		while (soldiers.size() != 2)
		{
			for (int a = 0; a < k-1; a++)
			{
				iter++;
				if (iter == soldiers.end()) iter = soldiers.begin();
			}
			iter = soldiers.erase(iter);
			if(iter==soldiers.end()) iter = soldiers.begin();
		}
		iter = soldiers.begin();
		int first = *iter;
		iter++;
		int second = *iter;
		if (first < second) cout << first + 1<< " " << second + 1 << endl;
		else cout << second + 1 << " " << first + 1 << endl;
	}
	return 0;
}
#include <iostream>
#include <list>

using namespace std;

int main()
{
	int n, k;
	cin >> n;
	cin >> k;
	//list initialize
	list<int> soldiers;
	for (int j = 0; j < n; j++)
	{
		soldiers.push_back(j+1);
	}
	list<int>::iterator iter = soldiers.begin();
	cout << "<";
	while (1)
	{
		for (int a = 0; a < k - 1; a++)
		{
			iter++;
			if (iter == soldiers.end()) iter = soldiers.begin();
		}
		cout << *iter;
		iter = soldiers.erase(iter);
		if (iter == soldiers.end()) iter = soldiers.begin();
		if (soldiers.size() == 0) break;
		cout << ", ";
	}
	cout << ">";
	return 0;
}
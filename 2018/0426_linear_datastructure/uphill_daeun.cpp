#include <iostream>
#include <vector>

using namespace std;
vector<int> h;

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int t;
		cin >> t;
		h.push_back(t);
	}
	vector<int> up;
	int cur = 0;
	up.push_back(0);
	for (vector<int>::iterator iter = h.begin(); ;)
	{
		int val = *iter;
		++iter;
		if (iter == h.end()) break;
		if (val < *iter)	up[cur] += *iter - val;
		else
		{
			up.push_back(0);
			cur++;
		}
	}
	int max = 0;
	for (int i = 0; i < up.size(); i++)
	{
		if (up[i] > max) max = up[i];
	}
	cout << max << endl;
	return 0;
}
#include <iostream>
#include <vector>

using namespace std;

vector<int> a[1001];
int _dt[1001];
int min = 1002;
int n;


int search(int x,int avoid)
{
	int rt_sum = 0;
	for (int i = 0; i < a[i].size(); ++i) {
		if (a[x][i] == avoid)
			return 0;
		rt_sum += _dt[search(a[x][i], avoid)];
	}
	return rt_sum;
}

int find(void)
{
	for (int i = 1; i < n; ++i) {
		for (int j = 0; j < a[i].size(); ++j) {
			int sum_stnode = search(i, a[i][j]);
			int sum_ednode = search(a[i][j],i);
			if (min > abs(sum_stnode - sum_ednode))
				min = abs(abs(sum_stnode - sum_ednode));
		}
	}
	return min;
}


int main(void)
{

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> _dt[i];
	}
	for (int i = 1; i <= n - 1; ++i) {
		int x, y;
		cin >> x >> y;
		a[x].push_back(y);
		a[y].push_back(x);
	}
	
	cout << find();
	return 0;
}

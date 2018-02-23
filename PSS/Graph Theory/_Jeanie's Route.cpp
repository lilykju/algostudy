#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int mval = -1000000000;
int n, k, m = 0, s[500001], sum;
bool f[500001];
vector<int> val[500001], dist[500001];

void input(void) {
	cin >> n >> k;
	for (int i = 0; i < k; ++i) {
		int x;
		cin >> x;
		s[x] = 1;
		f[x] = 1;
	}
	for (int i = 1; i < n; ++i) {
		int x, y, z;
		cin >> x >> y >> z;
		val[x].push_back(y);
		val[y].push_back(x);
		dist[x].push_back(z);
		dist[y].push_back(z);
	}
}

int dfs(int x, int from) {
	int D1 = mval;
	int D2 = mval;
	
	int len = val[x].size();
	for (int i = 0; i < len; ++i) { // find all node
		if (val[x][i] != from) {
			D1 = max(D1, dfs(val[x][i], x) + dist[x][i]);
			if (D1 > D2) swap(D1, D2);
			s[x] += s[val[x][i]];
			if (0 < s[val[x][i]] && s[val[x][i]] < k) sum += dist[x][i];
		}
	}

	cout << "D1 : " << D1 << endl;
	cout << "D2 : " << D2 << endl;
	if (D1 > 0) m = max(m, D1 + D2);

	cout << "D1 : " << D1 << endl;
	cout << "D2 : " << D2 << endl;
	if (D2 > 0 && f[x]) m = max(m, D2);

	cout << "D1 : " << D1 << endl;
	cout << "D2 : " << D2 << endl;
	if (f[x]) D2 = max(D2, 0);

	cout << "D1 : " << D1 << endl;
	cout << "D2 : " << D2 << endl;

	cout << "\n\n";

	return D2;
}

int main(void)
{
	input();
	dfs(1, 1);
	cout << sum * 2 - m;
	return 0;
}
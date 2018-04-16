#include <iostream>
#include <algorithm>

using namespace std;

int p[10001];
int d[10001][2];

int main(void)
{
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> p[i];
	}
	d[1][0] = p[1];
	d[1][1] = p[1];
	d[2][0] = p[2];
	d[2][1] = p[2] + p[1];
	for (int i = 3; i <= n; ++i) {
		d[i][0] = max(d[i - 2][0], d[i - 2][1]) + p[i];
		d[i][1] = d[i - 1][0] + p[i];
	}
	cout << max(d[n][0], d[n][1]);
	return 0;
}
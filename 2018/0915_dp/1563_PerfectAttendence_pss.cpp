#include <iostream>
#include <cstring>

using namespace std;

const int mod = 1000000;
int n;
int dp[1001][3][4];

int f(int d, int cnt1, int cnt2) {
	if (cnt1 == 2 || cnt2 == 3) {
		return 0;
	}

	if (d == n) {
		return 1;
	}

	int& ret = dp[d][cnt1][cnt2];
	if (ret != -1) {
		return ret;
	}

	ret = f(d + 1, cnt1, 0) +
		f(d + 1, cnt1 + 1, 0) +
		f(d + 1, cnt1, cnt2 + 1);

	return ret % mod;
}

int main(void) {
	cin >> n;

	memset(dp, -1, sizeof(dp));

	cout << f(0, 0, 0) % mod;
	return 0;
}
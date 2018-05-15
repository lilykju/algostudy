#include <iostream>
#include <set>
#include <cstring>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string must, up, down;
int n;
int upsize;
int downsize;

int dp[1001][1001][2];
//bool upgo => True이면 다음에 up을 돌아야 한다는 것 
int go(int idx, int mustidx,bool upgo) {
	if (mustidx == n) {
		return 1;
	}

	int& ret = dp[idx][mustidx][upgo];
	if (ret != -1) {
		return ret;
	}
	ret = 0;
	for (int i = idx + 1; i < upsize; ++i) {
		if (upgo && must[mustidx] == up[i]) {
			ret += go(i, mustidx + 1, false);
		}
	}
	for (int i = idx + 1; i < downsize; ++i) {
		if (!upgo && must[mustidx] == down[i]) {
			ret += go(i, mustidx + 1, true);
		}
	}
	return ret;
}

int main(void) {
	memset(dp, -1, sizeof(dp));
	cin >> must >> up >> down;
	int ans = 0;
	n = must.size();
	upsize = up.size();
	downsize = down.size();
	for (int i = 0; i < upsize; ++i) {
		if (must[0] == up[i])
			ans += go(i, 1, false);
	}
	for (int i = 0; i < downsize; ++i) {
		if(must[0] == down[i])
			ans += go(i,1,true);
	}
	cout << ans << endl;
	return 0;
}
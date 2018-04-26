#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int sch[10][16] = {
	{ 3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0 },
{ 0,0,0,3,0,0,0,3,0,3,0,3,0,0,0,0 },
{ 0,0,0,0,3,0,0,0,0,0,3,0,0,0,3,3 },
{ 0,0,0,0,3,3,3,3,0,0,0,0,0,0,0,0 },
{ 3,0,0,0,3,3,3,3,0,0,0,0,0,0,0,0 },
{ 0,0,0,0,0,0,3,3,3,0,3,0,3,0,0,0 },
{ 0,0,3,0,0,0,0,0,0,0,0,0,0,0,3,3 },
{ 0,0,0,3,3,0,3,0,0,0,0,0,0,0,3,3 },
{ 0,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0 },
{ 0,0,0,3,3,3,0,0,0,3,0,0,0,3,0,0 }

};

int go(vector<int>& arr, int swch) {
	if (swch == 10) {
		bool ans = true;
		for (int i = 0; i < 16; ++i) {
			if (arr[i] != 12) {
				ans = false;
			}
		}
		return ans ? 99999 : 0;
	}

	int ret = 99999;
	for (int cnt = 0; cnt < 4; ++cnt) {
		ret = min(ret, cnt + go(arr, swch + 1));
		for (int i = 0; i < 16; ++i) {
			arr[i] += sch[swch][i];
			if (arr[i] == 15) {
				arr[i] = 3;
			}
		}
	}
	return ret;
}

int main(void)
{
	int t;
	cin >> t;
	vector<int> arr(16);
	while (t--) {
		for (int i = 0; i < 16; ++i) {
			cin >> arr[i];
		}
		int ans = go(arr, 0);
		cout << (ans > 9999 ? -1 : ans) << '\n';
	}
	return 0;
}
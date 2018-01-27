#include <iostream>
#include <vector>

#define Max(a,b) ((a)>(b))?(a):(b)

using namespace std;

int main() {
	int t;
	cin >> t;
	while (t--) {
		int sum[100001][2];
		int n;
		cin >> n;
		vector<int> arr(n);
		for (int i = 0; i < n; ++i) {
			cin >> arr[i];
		}
		
		for (int i = 1; i < n; ++i) {
			sum[i][0] = Max(sum[i-1][0],sum[i - 1][1] + arr[i - 1] - 1);
			sum[i][1] = Max(sum[i-1][1],sum[i - 1][0] + arr[i] - 1);
		}
		int ans = Max(sum[n - 1][0], sum[n - 1][1]);
		cout << ans << '\n';
	}
	return 0;
}


#include <iostream>

using namespace std;

int main(void)
{
	int t;
	cin >> t;
	while (t--){
		int a[100001];
		int tt;
		cin >> tt;
		int sum = 0, ans = 0, sumcnt = 0;
		for (int i = 0; i < tt; ++i)
			cin >> a[i];

		for (int i = 0; i < tt; ++i) {
			sumcnt++;
			sum += a[i];
			if (a[i] < a[i + 1]) {
				ans += (a[i+1] * sumcnt - sum);
				sumcnt = sum = 0;
			}
		}
		cout << sum << endl;
	}
	return 0;
}
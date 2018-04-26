#include <iostream>
#include <algorithm>

using namespace std;

int a[100001];
int d[100001];
int main(void)
{
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		for (int i = 0; i < n; ++i) {
			cin >> a[i];
		}
		d[0] = 0;
		long long seq = -999999999999;
		
		int maxd = a[0];
		bool plus = false;
		for (int i = 1; i <= n; ++i) {
			if (!plus) {
				if (a[i - 1] < 0) {
					seq = max(seq, (long long)a[i - 1]);
				}
				else {
					plus = true;
					seq = 0;
				}
			}
			if (a[i - 1] > 0 && plus) {
				seq += a[i - 1];
			}
			d[i] = max(d[i - 1] + a[i - 1], a[i-1]);
			if (d[i] > maxd) {
				maxd = d[i];
			}
		}
		cout << maxd << ' ' << seq << endl;
		
	}
	return 0;
}

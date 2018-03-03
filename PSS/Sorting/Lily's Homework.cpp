#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
ll p[100001];
ll b[100001];
ll bb[100001];

int main(void)
{
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> p[i];
		b[i] = p[i];
		bb[i] = p[i];
	}
	sort(p, p + n);
	ll cnt=0;
	for (int i = 0; i < n; ++i) {
		if (p[i] != b[i]) {
			for (int j = i+1; j < n; ++j) {
				if (p[i] == b[j]) {
					swap(b[i], b[j]);
					cnt++;
					break;
				}
			}
		}
	}
	ll ccnt = 0;
	reverse(p, p + n);
	for (int i = 0; i < n; ++i) {
		if (p[i] != bb[i]) {
			for (int j = i + 1; j < n; ++j) {
				if (p[i] == bb[j]) {
					swap(bb[i], bb[j]);
					ccnt++;
					break;
				}
			}
		}
	}
	cout << min(cnt, ccnt) << endl;
	return 0;
}

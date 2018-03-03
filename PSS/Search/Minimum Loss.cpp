#include <iostream>
#include <algorithm>

using namespace std;

typedef unsigned long long ll;

typedef struct {
	ll year;
	ll val;
}sol;

bool cmp(const sol& u, const sol& v) {
	if (u.val < v.val)
		return true;
	return false;
}

int main(void)
{
	ll n;
	cin >> n;
	sol s[200001];
	for (int i = 0; i < n; ++i) {
		ll k;
		s[i].year = i + 1;
		cin >> k;
		s[i].val = k;
	}

	sort(s, s + n, cmp);

	ll min = 1000000000000000LL;
	for (int i = 0; i < n - 1; ++i) {
		ll temp1 = s[i + 1].val - s[i].val;
		bool temp2 = s[i].year > s[i + 1].year;
		if (temp1 > 0 && temp2 && temp1 < min) {
			min = temp1;
			//	cout << max << endl;
		}
	}
	cout << min;
	return 0;

}

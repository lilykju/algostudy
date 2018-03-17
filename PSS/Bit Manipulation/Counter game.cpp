#include <iostream>

using namespace std;

typedef unsigned long long ll;


int gocnt = 0;
ll go(ll x)
{
	gocnt++;
	if (x == 1) {
		return 0;
	}
	int cnt = 0;
	int largei;
	for (ll i = 0; i < 64; ++i) {
		if (x & (ll(1) << i)) {
			cnt++;
			largei = i;
		}
	}
	
	if (cnt == 1) {
		//cout << "cnt1 on" << endl;
		go(x - x / 2);
	}
	else {
		//cout << "cntelse on" << endl;
		//cout << largei << endl;
		go(x - (ll(1) << largei));
	}
	return 0;
}

int main(void)
{
	ll t;
	cin >> t;
	while (t--) {
		ll n;
		cin >> n;
		//cout << gocnt << endl;
		go(n);
		cout << (!(gocnt%2) ? "Louise" : "Richard") << endl;
		gocnt=0;
	}
	return 0;
}

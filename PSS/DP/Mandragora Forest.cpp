#include <iostream>
#include <algorithm>

using namespace std;

typedef long long ll;

ll p[1000001];
ll d[1000001];

int main(void) {
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		for (int i = 1; i <= n; ++i) {
			cin >> p[i];
		}

		sort(p + 1, p + n+1);
		//p[0] mean no increase
		ll psum = 0;
		for (int j = 1; j <= n; ++j) {
			psum += p[j];
		}

		ll ans = -1;
		for (int i = 0; i <= n; ++i) {
			psum -= p[i]; 
			d[i] = (i+1)*psum;
			
			if (d[i] > ans) {
				ans = d[i];
			}
			else 
				break;
		}
	/*	for (int i = 0; i <= n; ++i) {
			cout << p[i] << ' ';
			if (i % 5 == 0) {
				cout << endl;
			}
		}*/
		//for (int i = 0; i <= n; ++i) {
		//	//cout << "s : " << i+1 << " and p[i] : " << p[i] << endl;
		//	cout << "i : " << i << " and d[i] : "<< d[i] << endl;
		//}
		//
		cout << ans << endl;
	}
}
#include<iostream>
#include<algorithm>
using namespace std;
int main() {

	int t;
	cin >> t;

	for(int i = 1; i <= t; i++){

		int n, m, k;
		cin >> n >> m >> k;

		int a[100];
		
		for(int i = 0; i < n; i++){
			cin >> a[i];
		}

		sort(a, a+n);

		int check = 0;

		for (int i = 0; i < n; i++) {
			int ppang = (a[i]/ m);
			if ((ppang - i) <= 0) {
				check = 1; break;
			}
		}
		if (check == 1)
			cout << "#" << i << " Impossible" << endl;
		else
			cout << "#" << i << " Possible" << endl;
	}

	return 0;
}
#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main() {
	int len;
	cin >> len;
	string N;
	cin >> N;
	int cnt = 0;
	int ans = 0;
	for (int i = 0; i < len; i++) {
		if (N[i] == 'x') {
			cnt++;
			if (cnt == 3) {
				ans++;
				cnt = 2;
			}
		}
		else {
			cnt = 0;
		}
	}
	cout << ans;
}

#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <string>
#include <cstring>

#define GO

using namespace std;

/*

5 21
-3 2 -4 -1 -5

*/


int main(void) {

#ifdef GO
	freopen("input.txt", "r", stdin);
#endif

	int n;
	cin >> n;
	vector<string> s(n);
	for (int i = 0; i < n; ++i) {
		cin >> s[i];
	}
	

	for (int i = 0; i < n; ++i) {
		int flen = s[i].size();
		for (int j = i + 1; j < n; ++j) {
			//cout << s[i] << ' ' << s[j] << endl;
			int slen = s[j].size();
			if (flen != slen) {
				continue;
			}
			int k;
			for (k = 0; k < slen; ++k) {
				if (s[i][k] != s[j][slen - k - 1]) {
					break;
				}
			}
			if (k == slen) {
				cout << slen << ' ' << s[i][k / 2] << endl;
				return 0;
			}
			/*		cout << k << endl;*/

		}
	}
	cout << s[0].size() << ' ' << s[0][s[0].size() / 2] << endl;

	return 0;
}
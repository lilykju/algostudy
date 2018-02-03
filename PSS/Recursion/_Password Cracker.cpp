#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;


int main(void)
{
	int t;
	cin >> t;
	while (t--) {
		int tt;
		cin >> tt;
		string ss[1001];
		vector<string> ans;
		for (int i = 0; i < tt; ++i) {
			cin >> ss[i];
		}
		string cmp;
		cin >> cmp;

		int now_len = 0,k;
		for (int i = 0; i < tt; ++i) {
			for (int j = now_len; j < cmp.length(); ++j) {
				int temp_now_len = now_len;
				for (k = 0; k < ss[i].size(); ++k) {
					if (ss[i][k] == cmp[j]) {
						now_len++;
						j++;
					}
					else {
						break;
					}
				}
				if (k == ss[i].size()) {
					ans.push_back(ss[i]);
					ans.push_back(" ");
					i = -1;
					break;
				}
				if (k < ss[i].size()) {
					now_len = temp_now_len;
					j = now_len;
					break;
				}
			}
		}

		if (now_len != cmp.length()) {
			cout << "WRONG PASSWORD" << endl;
		}
		else {
			for (int i = 0; i < ans.size(); ++i) {
				cout << ans[i];
			}
			cout << endl;
		}
	}
	return 0;
}
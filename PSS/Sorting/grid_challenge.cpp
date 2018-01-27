#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
	int t;
	cin >> t;
	string st[100];
	bool ch = true;
	while (t--) {
		int tt;
		cin >> tt;
		for (int i = 0; i < tt; ++i) {
			string temp;
			cin >> temp;
			sort(temp.begin(), temp.end());
			st[i] = temp;
		}
		for (int i = 1; i < tt && ch; ++i) {
			for (int j = 0; j < tt && ch; ++j)
				if (st[i - 1][j] > st[i][j])
					ch = false;
		}
		cout << (ch ? "YES" : "NO") << '\n';
		ch = true;
	}
	return 0;
}
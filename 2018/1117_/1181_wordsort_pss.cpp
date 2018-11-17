#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
#include <fstream>
#include <string>
#include <cstring>
#include <map>
#include <set>

#define pii pair<int, int>
#define pli pair<long, int>
#define mii map<int, int>
#define msi map<string, int>

typedef unsigned long long ull;
typedef long long ll;

using namespace std;





/*

5 21
-3 2 -4 -1 -5

*/


int main(void) {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
#ifdef GO
	freopen("input.txt", "r", stdin);
#endif

	int n;
	cin >> n;
	set<string> s[51];
	string st;
	int len;
	for (int i = 0; i<n; ++i) {
		cin >> st;
		len = st.size();
		s[len].insert(st);
	}

	set<string>::iterator it;
	for (int i = 1; i <= 50; ++i) {
		for (it = s[i].begin(); it != s[i].end(); ++it) {
			cout << *it << '\n';
		}
	}

















#ifdef GO
	cout << "\nerase go\n";
#endif

	return 0;
}
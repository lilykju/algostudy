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

#define GO
#define DEBUG

int abssub(int a, int b) {
	if (b < a) {
		return a - b;
	}
	return b - a;
}


int arr[101];
int main(void) {
#ifdef GO
	freopen("input.txt", "r", stdin);
#endif
	int t;
	cin >> t;
	while (t--) {
		memset(arr, 0, sizeof(arr));
		int a, b;
		cin >> a >> b;
		for (int i = 0; i < b; ++i) {
			cin >> arr[i];
		}
		sort(arr, arr + b);
		int arridx = 0;
		vector<int> ret;
		for (int i = 1; i <= a && arridx <= b; ++i) {
			if (arr[arridx] != i) {
				ret.push_back(i);
			}
			else {
				arridx++;
			}
		}
		for (auto x : ret) {
			cout << x << ' ';
		}
		cout << '\n';
	}

	
#ifdef GO
	cout << "\nerase go\n";
#endif

	return 0;
}
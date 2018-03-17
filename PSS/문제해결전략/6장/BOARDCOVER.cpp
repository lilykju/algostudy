#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int n;

bool friendarray[10][10];

int find(bool is_friend[10]) {
	int firstFree = -1;
	for (int i = 0; i < n; ++i) {
		if (is_friend[i] == false){
			firstFree = i;
			break;
		}
	}
	if (firstFree == -1) {
		return 1;
	}
	int ret = 0;

	for (int i = firstFree+1; i < n; ++i) {
		
		if (!is_friend[i] && friendarray[firstFree][i]) {
			is_friend[firstFree] = is_friend[i] = true;
			ret += find(is_friend);
			is_friend[firstFree] = is_friend[i] = false;
		}
		
	}
	return ret;
}

int main(void)
{
	bool is_friend[10];
	int t;
	cin >> t;
	while (t--) {
		memset(is_friend, false, sizeof(is_friend));
		memset(friendarray, false, sizeof(friendarray));
		int m;//n 친구의수 m 쌍의 수
		cin >> n >> m;
		for (int i = 0; i < m; ++i) {
			int x, y;
			cin >> x >> y;
			friendarray[x][y] = true;
			friendarray[y][x] = true;
		}
		cout << find(is_friend) << endl;
	}
}

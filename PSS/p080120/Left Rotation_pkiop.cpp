/*
	input배열에 원래 배열을 넣는다
	left shift 한 배열값을 ans 배열에 넣는다.
	왼쪽으로 d 만큼 가는 건 i-d 로 구현할 수 있고
	index가 0보다 작아지는 경우는 n을 더해줘서 뒤로 가게 만들었다.

	시간복잡도 : O(n)
	공간복잡도 : 4byte*n
	*/

#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n, d;
	cin >> n >> d;
	vector<int> input(n);
	vector<int> ans(n);
	for (int i = 0; i < n; ++i) {
		cin >> input[i];
	}
	for (int i = 0; i < n; ++i) {
		if (i - d < 0) {
			ans[n + (i - d)] = input[i];
		}
		else {
			ans[i - d] = input[i];
		}
	}
	for (int i = 0; i < n; ++i) {
		cout << ans[i] << ' ';
	}
	return 0;
}
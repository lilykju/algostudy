#include <iostream>
#include <vector>
#include<string>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector<string> arr[6];

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		int len = temp.size();
		arr[len / 2 - 1].push_back(temp);
	}

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < arr[i].size(); j++) {
			for (int z = j ; z < arr[i].size(); z++) {
				bool ans = true;
				int len = (i + 1) * 2 + 1;
				// 기준문자열 arr[i][j] 비교문자열 arr[i][j]
				for (int k = 0; k < len; k++) {
					if (arr[i][j][k] != arr[i][z][len - 1 - k]) {
						ans = false;
						break;
					}
				}
				if (ans) {
					cout << len << " ";
					cout << arr[i][j][len / 2];
					return 0;
				}
			}
		}
	}
}

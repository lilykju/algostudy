/*
	38미만의 수는 제외하고 5의 배수마다 반올림을 하는 문제
	5미만에서 반올림 되는 경우 => 38이상, 나머지가 3,4
	5이상에서 반올림 되는 경우 => 38이상, 나머지가 8,9
	나머지 모든 경우는 그대로 다시 저장

	시간복잡도 O(len)
	공간복잡도 입력받은 숫자 * 12byte(같은 길이의 배열 3개)
*/

#include <iostream>
#include <vector>

using namespace std;

vector<int> solve(vector <int> grades) {
	vector<int> retn;
	int len = grades.size();
	for (int i = 0; i < len; ++i) {
		int k = grades[i];
		if (k % 10 >= 3 && k % 10 <= 4 && k>=38) {
			retn.push_back((k / 10)*10 + 5);
		}
		else if (k % 10 >= 8 && k % 10 <= 9 && k >= 38) {
			retn.push_back((k / 10) * 10 + 10);
		}
		else {
			retn.push_back(grades[i]);
		}
	}
	return retn;
}

int main() {
	int n;
	cin >> n;
	vector<int> grades(n);
	for (int grades_i = 0; grades_i < n; grades_i++) {
		cin >> grades[grades_i];
	}
	vector <int> result = solve(grades);
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << (i != result.size() - 1 ? "\n" : "");
	}
	cout << endl;

	return 0;
}

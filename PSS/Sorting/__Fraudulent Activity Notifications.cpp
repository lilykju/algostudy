#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(void)
{
	int n, for_check;
	cin >> n >> for_check;
	vector<int> a;
	queue<int> q;
	int noti = 0;
	for (int i = 0; i < for_check; ++i) { // 첫 for_check개 원소를 배열에 저장
		int k;
		cin >> k;
		a.push_back(k);
		q.push(k);
	}

	bool ch_tf = for_check % 2 != 0;

	int mid;
	for (int i = 0; i < n - for_check; ++i) {

		int next_num;
		cin >> next_num; //다음 숫자

		if (ch_tf) {
			nth_element(a.begin(),a.begin()+for_check/2, a.end());
			mid = a[for_check / 2] * 2;
		}
		else {
			nth_element(a.begin(),a.begin()+for_check/2, a.end());
			int tem1 = a[for_check / 2];
			nth_element(a.begin(),a.begin()+for_check/2-1, a.end());
			int tem2 = a[for_check / 2-1];
			mid = tem1 + tem2;
		}

		if (next_num >= mid) {
			noti++;
		}

		int sequence_check = q.front();
		q.pop();

		for (int j = 0; j < for_check; ++j) {
			if (sequence_check == a[j]) {
				a[j] = next_num;
				q.push(next_num);
				break;
			}
		}
	}
	cout << noti;
	return 0;
}
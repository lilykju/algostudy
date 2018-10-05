#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
typedef long long ll;
int arr[101];
int visit[101];
int arr2[101];
typedef pair<int, int> pii;

int main() {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		arr[temp]++;
		arr2[i] = temp;
	}

	int cnt = 0;
	int thr = 0;
	for (int i = 0; i < 101; i++) {
		if (arr[i] == 1)
			cnt++;
		else if (arr[i] >= 3)
			thr++;
	}
	bool flag = false;
	bool asd = false;
	if (cnt % 2 == 0) {
		cout << "YES\n";
		for (int i = 0; i < N; i++) {
			int num = arr2[i];
			if (arr[num] == 1) {
				if (flag)
					cout << "A";
				else
					cout << "B";
				flag = !flag;
			}
			else
				cout << "A";
		}
	}
	else if ((cnt) % 2 == 1 && thr>0) {
		cout << "YES\n";
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int num = arr2[i];
			if (arr[num] == 1) {
				if (flag)
					cout << "A";
				else
					cout << "B";
				flag = !flag;
			}
			else if (arr[num] >= 3 && ans == 0) {
				if (flag) {
					cout << "A";
					ans = 1;
				}
					
				else {
					cout << "B";
					ans = 2;
				}
				flag = !flag;
			}
			else{
				if (ans == 1)
					cout << "B";
				else
					cout << "A";

			}
		}
	}
	else {
		cout << "NO";
	}
}

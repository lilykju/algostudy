#include<iostream>
#include<vector>
using namespace std;
int arr[51];
int visit[1001];

int main() {
	int N;
	scanf("%d", &N);
	vector<int> result;
	for (int i = 0; i < N; i++) {
		int temp;
		scanf("%d", &temp);
		arr[i] = temp;
	}
	for (int i = N - 1; i >= 0; i--) {
		if (visit[arr[i]])
			continue;
		visit[arr[i]] = 1;
		result.push_back(arr[i]);
	}
	cout << result.size() << endl;
	for (int i = result.size()-1; i>=0; i--) {
		printf("%d ", result[i]);
	}


}

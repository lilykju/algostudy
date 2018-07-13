#include<iostream>
#include<cstring>
#include<string>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;
int arr[101][101];
int p[101];
int c[101];
int N, M;
vector<int> ans;
priority_queue<pair<int, int> >qu;

int find(int a) {
	if (a == p[a])
		return a;
	return p[a] = find(p[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)
		return;
	p[a] = b;
}


int main() {
	scanf("%d %d", &N, &M);

	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			arr[i][j] = 1e9;
		}
	}

	for (int i = 1; i <= N; i++) {
		p[i] = i;
	}

	for (int i = 0; i < M; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		arr[x][y] = 1;
		arr[y][x] = 1;
	}
	
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			for (int k = 1; k <= N; k++) {
				if (arr[j][i] + arr[i][k] < arr[j][k]) {
					arr[j][k] = arr[j][i] + arr[i][k];
				}
			}
		}
	}


	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] != arr[0][0]) {
				merge(i, j);
			}
		}
	}
	
	for (int i = 1; i <= N; i++) {
		int here = 0;
		for (int j = 1; j <= N; j++) {
			if (i == j)
				continue;
			if (arr[i][j] == arr[0][0])
				continue;
			if (arr[i][j] > here)
				here = arr[i][j];
		}
		qu.push({ -here,i });
	}

	while (!qu.empty()) {
		int here = qu.top().second;
		qu.pop();
		if (c[find(here)])
			continue;
		ans.push_back(here);
		c[find(here)] = 1;
	}

	sort(ans.begin(), ans.end());
	cout << ans.size() << "\n";
	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i] << "\n";
	}
}

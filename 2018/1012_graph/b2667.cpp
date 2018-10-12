#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n;
int a[1001][1001];
int b[1001][1001];
int an[30 * 30];
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
queue< pair<int,int>> q;


void bfs(int x, int y,int gr) {
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int nx = q.front().first;
		int ny = q.front().second;
		b[nx][ny] = gr;
		q.pop();
		for (int k = 0; k < 4; ++k) {
			int tx = nx + dx[k];
			int ty = ny + dy[k];
			if (0 <= tx && tx < n && 0 <= ty && ty < n) {
				if (!b[tx][ty] && a[tx][ty] == 1) {
					q.push(make_pair(tx, ty));
				}
			}
		}
	}
}

int main(void) {
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			scanf("%1d", &a[i][j]);
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (!b[i][j] && a[i][j] == 1) {
				bfs(i, j, ++cnt);
			}
		}
	}
	cout << cnt << endl;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			an[b[i][j]]++;
		}
	}
	sort(an+1, an+cnt+1);
	for (int i = 1; i <= cnt; ++i) {
		cout << an[i] << endl;
	}

	return 0;

}


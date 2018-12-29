#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <string>
#include <cstring>
#include <queue>


using namespace std;

/*

5 21
-3 2 -4 -1 -5

*/

char arr[1001][1001];
int visited[1001][1001];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

struct pr {
	int x, y;
};

int main(void) {

#ifdef GO
	freopen("input.txt", "r", stdin);
#endif
	int t;
	t = 1;
	while (t--) {
		pr start;
		int n, m;
		cin >> m >> n;
		vector<pr> fire;
		char trash;
		scanf("%c", &trash);
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				scanf("%1c", &arr[i][j]);
				if (arr[i][j] == 'J') {
					start.x = i;
					start.y = j;
				}
				if (arr[i][j] == 'F') {
					fire.push_back({ i, j });
				}
			}
			scanf("%c", &trash);
		}
		memset(visited, -1, sizeof(visited));

		int fire_len = fire.size();
		for (int i = 0; i < fire_len; ++i) {
			queue<pr> fq;
			fq.push(fire[i]);
			visited[fire[i].x][fire[i].y] = 1;
			while (!fq.empty()) {
				pr temp = fq.front();
				fq.pop();
				for (int k = 0; k < 4; ++k) {
					int nx = temp.x + dx[k];
					int ny = temp.y + dy[k];
					if (0 <= nx && nx < m && 0 <= ny && ny < n) {
						if (arr[nx][ny] == '.' && visited[nx][ny] < visited[temp.x][temp.y] + 1) {
							arr[nx][ny] = 'F';
							visited[nx][ny] = visited[temp.x][temp.y] + 1;
							fq.push({ nx,ny });
						}
					}
				}
			}
		}

		queue<pr> q;
		q.push(start);
		visited[start.x][start.y] = 1;
		while (!q.empty()) {
			pr temp = q.front();
			q.pop();
			for (int k = 0; k < 4; ++k) {
				int nx = temp.x + dx[k];
				int ny = temp.y + dy[k];
				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if ((arr[nx][ny] == 'F' ||arr[nx][ny] == '.') && (visited[nx][ny] > visited[temp.x][temp.y] + 1 || visited[nx][ny] == -1)) {
						arr[nx][ny] = 'J';
						visited[nx][ny] = visited[temp.x][temp.y] + 1;
						q.push({ nx,ny });
					}
				}
			}
		}

		

		//외곽체크
		int ans = 99999999;
		for (int i = 0; i < m; ++i) {
			if (arr[i][0] == 'J') {
				ans = min(ans, visited[i][0]);
			}
			if (arr[i][n - 1] == 'J') {
				ans = min(ans, visited[i][n - 1]);
			}
		}

		for (int i = 0; i < n; ++i) {
			if (arr[0][i] == 'J') {
				ans = min(ans, visited[0][i]);
			}
			if (arr[m - 1][i] == 'J') {
				ans = min(ans, visited[m - 1][i]);
			}
		}

		if (ans == 99999999) {
			cout << "IMPOSSIBLE" << endl;
			continue;
		}
		cout << ans << endl;
	}

	return 0;
}
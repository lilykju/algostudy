#include<iostream>
#include<queue>
#include<cstring>

using namespace std;

int arr[303][303];
int visit[303][303];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

int nonzero = 0;
int visittime;
int N, M;

void dfs(int x, int y) {
	visittime++;
	int cnt = 0;
	visit[x][y] = 1;
	for (int i = 0;i < 4;i++) {
		int next_x = x + dx[i];
		int next_y = y + dy[i];
		if (next_x < N && next_x >= 0 && next_y >= 0 && next_y < M) {
			if (visit[next_x][next_y] == 1)
				continue;
			if (arr[next_x][next_y] <= 0)
				cnt++;
			else
				dfs(next_x, next_y);
		}
	}
	if (arr[x][y] > cnt)
		arr[x][y] -= cnt;
	else {
		arr[x][y] = 0;
		nonzero--;
	}
		
}
int main() {
	scanf("%d %d",&N,&M);
	for (int i = 0;i < N;i++) {
		for (int j = 0;j < M;j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] != 0)
				nonzero++;
		}
	}
	int ans = 0;
	while (1) {
		int before = nonzero;
		ans++;
		memset(visit, 0, sizeof(visit));
		int x, y;
		visittime = 0;
		bool find = false;
		bool tostop = false;
		for (int i = 0;i < N;i++) {
			for (int j = 0;j < N;j++) {
				if (arr[i][j] > 0) {
					x = i;
					y = j;
					tostop = true;
					find = true;
				}
			}
			if (tostop)
				break;
		}
		if (!find)
			return !printf("%d", 0);
		dfs(x, y);
		if (visittime != before) {
			return !printf("%d", ans-1);
		}
	}
}

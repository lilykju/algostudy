#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<queue>
typedef long long ll;
using namespace std;
typedef pair<int, int> pii;
int N;
int arr[102][102];
int visit[102][102];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

void dfs(int x,int y) {
	for (int i = 0;i < 4;i++) {
		int next_x = x + dx[i];
		int next_y = y + dy[i];
		if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < N) {
			if (visit[next_x][next_y] == 0) {
				visit[next_x][next_y] = 1;
				dfs(next_x, next_y);
			}
				
		}
	}
	return;
}
int main()
{
	int mas = 0;
	scanf("%d", &N);
	for (int i = 0;i<N;i++) {
		for (int j = 0;j<N;j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j]>mas)
				mas = arr[i][j];
		}
	}
	int ans = 0;
	for (int rain = 0;rain<mas;rain++) {
		int cnt = 0;
		memset(visit, 0, sizeof(visit));
		queue<pii> qu;
		for (int i = 0;i<N;i++) {
			for (int j = 0;j<N;j++) {
				if (arr[i][j] > rain) {
					qu.push({ i,j });
				}
				else
					visit[i][j] = 1;
			}
		}
		while (!qu.empty()) {
			pii start = qu.front();
			qu.pop();
			if (visit[start.first][start.second] == 1)
				continue;
			cnt++;
			dfs(start.first, start.second);

		}
		if (cnt > ans)
			ans = cnt;
	}
	printf("%d", ans);


}


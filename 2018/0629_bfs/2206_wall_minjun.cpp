#include<iostream>
#include<queue>

using namespace std;
struct temp {
	int x, y, b;
};
int arr[1002][1002];
int visit[1002][1002][2];
int N, M;
int cnt;
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

queue<temp> qu;
void bfs() {
	while (!qu.empty()) {
		int len = qu.size();
		cnt++;
		for (int i = 0;i < len;i++) {
			temp here = qu.front();
			qu.pop();
			if (here.x == N - 1 && here.y == M - 1)
				return;
			for (int i = 0;i < 4;i++) {
				
				int nx = here.x+dx[i];
				int ny = here.y+dy[i];
				int can = here.b;
				//cout << nx << " " << ny << endl;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (visit[nx][ny][can] == 1)
						continue;
					if (arr[nx][ny] == 1) {
						if (can == 0) {
							qu.push({ nx,ny,1 });
							visit[nx][ny][1] = 1;
						}
						else
							continue;
					}
					else {
						qu.push({ nx,ny,can });
						visit[nx][ny][can] = 1;
					}
				}
			}
			
			

		}
	}
	cnt = -1;
}
int main() {
	scanf("%d %d", &N, &M);
;	for (int i = 0;i < N;i++) {
		for (int j = 0;j < M;j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
	qu.push({ 0,0,0 });
	bfs();
	printf("%d", cnt);
	
}

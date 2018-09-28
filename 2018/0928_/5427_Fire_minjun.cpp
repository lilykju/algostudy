//https://www.acmicpc.net/problem/5427

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<queue>
#include<string>
using namespace std;
typedef pair<int, int> pii;

int day;
int arr[1001][1001];
int visit[1001][1001];

int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

int main() {
	int T;
	scanf("%d", &T);
	queue<pii> pe;
	queue<pii> fire;
	for (int tc = 0; tc<T; tc++) {

		while (!pe.empty()) {
			pe.pop();
		}
		while (!fire.empty()) {
			fire.pop();
		}

		pii start;
		int N, M;
		day = 0;
		memset(arr, 0, sizeof(arr));
		memset(visit, 0, sizeof(visit));
		scanf("%d %d", &M, &N);
		for (int i = 0; i<N; i++) {
			string temp;
			cin >> temp;
			int len = temp.size();
			for (int j = 0; j<len; j++) {
				
				if (temp[j] == '.') { //빈공간
					arr[i][j] = 0;
				}
				else if (temp[j] == '#') { //벽
					arr[i][j] = 1;
				}
				else if (temp[j] == '@') { //시작위치
					pe.push({ i,j });

					arr[i][j] = 2;
				}
				else { // 불
					fire.push({ i,j });
					arr[i][j] = 3;
				}
			}
		}
		bool tofind = false;
		while (!pe.empty()) {
			if (tofind)
				break;
			day++;
			int firelen = fire.size();

			for (int i = 0; i<firelen; i++) {
				int hX = fire.front().first;
				int hY = fire.front().second;
				fire.pop();

				for (int k = 0; k<4; k++) {
					int nx = hX + dx[k];
					int ny = hY + dy[k];
					if (nx >= 0 && nx<N && ny >= 0 && ny<M && arr[nx][ny] == 0) {
						arr[nx][ny] = 3;
						fire.push({ nx,ny });
					}
				}
			}

			int pelen = pe.size();
			if (pelen == 0)
				break;
			
			for (int i = 0; i<pelen; i++) {

				int hX = pe.front().first;
				int hY = pe.front().second;
				if (hX == 0 || hX == N-1 || hY == 0 || hY == M-1) {
					
					tofind = true;
					
					break;
				}

				pe.pop();

				for (int k = 0; k<4; k++) {
					int nx = hX + dx[k];
					int ny = hY + dy[k];

					if (nx >= 0 && nx<N && ny >= 0 && ny<M && arr[nx][ny] == 0 && visit[nx][ny]==0) {
						visit[nx][ny] = 1;
						pe.push({ nx,ny });
					}
				}
			}

		}
		
		if (!tofind) {
			printf("IMPOSSIBLE\n");
		}

		else
			printf("%d\n", day);
	}

}

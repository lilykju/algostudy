#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int t;
char put[101][101];
bool ch[101][101];
int ch_section[101][101];
int dist[101][101];
int asum;
int x, y;
queue<pair<int, int> > q;
int m1, m2; //시작 
int s1, s2; //포트키 
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };


void input_findMS() // 입력받고 M위치, S위치  찾는다. 
{
	cin >> x >> y;
	for (int i = 0; i<x; ++i)
		for (int j = 0; j<y; ++j) {
			cin >> put[i][j];
			if (put[i][j] == 'M')
			{
				m1 = i;
				m2 = j;
			}
			if (put[i][j] == '*')
			{
				s1 = i;
				s2 = j;
			}
		}
	cin >> asum;
}

void search(void) {
	q.push(make_pair(m1, m2));
	int chcnt;
	dist[m1][m2] = 1;
	ch[m1][m2] = true;
	while (!q.empty()) {
		int xx = q.front().first;
		int yy = q.front().second;
		chcnt = 0;

		q.pop();
		for (int k = 0; k<4; ++k) {
			int nx = xx + dx[k];
			int ny = yy + dy[k];
			if (0 <= nx && nx < x && 0 <= ny && ny < y) {
				if (put[nx][ny] == '.' && ch[nx][ny] == false) {
					q.push(make_pair(nx, ny));
					ch[nx][ny] = true;
					ch_section[xx][yy] = ++chcnt;
					dist[nx][ny] = dist[xx][yy] + 1;
				}
			}

		}
	}
}

int ans;
void ans_search()
{
	ans = 0;
	for (int i = 0; i<x; ++i) {
		for (int j = 0; j<y; ++j) {
			if (ch_section[i][j] == 2 || ch_section[i][j] == 3 || ch_section[i][j] == 4)
				ans++;
		}
	}
}

void init(void) {
	for (int i = 0; i < 101; ++i) {
		for (int j = 0; j < 101; ++j) {
			put[i][j] = 'X';
			ch[i][j] = false;
			ch_section[i][j] = 0;
			dist[i][j] = 0;
		}
	}
}

queue<pair<int, int> > ans_xy;
bool ans_ch[101][101];

void after_touch(void)
{
	ans_xy.push(make_pair(m1, m2));
	while (!ans_xy.empty()) {
		int ans_x = ans_xy.front().first;
		int ans_y = ans_xy.front().second;
		ans_xy.pop();
		bool was_push = false;
		int k, nx, ny;
		for (k = 0; k < 4; ++k) {
			nx = ans_x + dx[k];
			ny = ans_y + dy[k];
			if (0 <= nx && nx < x && 0 <= ny && ny < y) {
				if (dist[nx][ny] == dist[ans_x][ans_y] + 1 && ans_ch[nx][ny] == false) {
					ans_xy.push(make_pair(nx, ny));
					ans_ch[nx][ny] = true;
					was_push = true;
				}
			}
		}
		if (!was_push && dist[nx][ny] != dist[s1][s2]) {
			while (1) {
				int temx = q.front().first;
				int temy = q.front().second;
				if (ch_section[temx][temy] == 1) {
					ch_section[temx][temy] = 0;
					ans_xy.pop();
				}
				else {
					break;
				}
			}
		}
	}
}


int main(void)
{
	cin >> t;
	while (t--) {
		init();
		input_findMS();
		search();
		ans_search();
		//after_touch();

		/*		for (int i = 0; i<x; ++i) {
		for (int j = 0; j<y; ++j) {
		cout << ch_section[i][j] << ' ';
		}
		cout << endl;
		}
		for (int i = 0; i<x; ++i) {
		for (int j = 0; j<y; ++j) {
		cout << dist[i][j] << ' ';
		}
		cout << endl;
		}
		cout << ans << endl;
		*/



		cout << (ans == asum ? "Impressed" : "Oops!") << endl;
	}
	return 0;
}


/*
if (xx == s1 && yy == s2) // *을 찾으면 q 돌릴필요 없다.
{
while (!q.empty()) {
q.pop();
}
break;
}
*/
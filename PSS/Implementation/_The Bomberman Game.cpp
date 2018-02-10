#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int t,n,cnt=1;
char put[201][201];
int ch[201][201];
int asum;
int x, y;
queue<pair<int, int> > q;
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };


void input() 
{
	cin >> x >> y >> n;
	for (int i = 0; i<x; ++i)
		for (int j = 0; j < y; ++j) {
			cin >> put[i][j];
			if (put[i][j] == 'O') {
				q.push(make_pair(i, j));
				ch[i][j] = 1;
			}
		}

}

void find(void) {
	for (int i = 0; i < x; ++i) {
		for (int j = 0; j < y; ++j) {
			if (put[i][j] == 'O') {
				q.push(make_pair(i, j));
			}
		}
	}
}

void search(void) {
	
	if (n % 2 == 1) {
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				if (put[i][j] == 'O') {
					ch[i][j]++;
				}
				if (put[i][j] == '.') {
					put[i][j] = 'O';
					ch[i][j] = 1;
				}
			}
		}
		return;
	}
	find();
	while (!q.empty()) {
		int xx = q.front().first;
		int yy = q.front().second;
		q.pop();

		if (put[xx][yy] == 'O' && ch[xx][yy] == 0 && ch[xx][yy] == 1) {
			ch[xx][yy]++;
			continue;
		}

		for (int k = 0; k < 4; ++k) {
			int nx = xx + dx[k];
			int ny = yy + dy[k];
			if (ch[xx][yy] == 2) {
				if (0 <= nx && nx < x && 0 <= ny && ny < y) {
					put[nx][ny] = '.';
					put[xx][yy] = '.';
				}
			}
		}
	}
}

void full_bomb(void) {
	find();
	
	while (!q.empty()) {
		int xx = q.front().first;
		int yy = q.front().second;
		q.pop();

		if (put[xx][yy] == 'O' && ch[xx][yy] == 1 && ch[xx][yy] == 2) {
			ch[xx][yy]++;
			continue;
		}

		for (int k = 0; k < 4; ++k) {
			int nx = xx + dx[k];
			int ny = yy + dy[k];
			if (0 <= nx && nx < x && 0 <= ny && ny < y) {
				if (put[xx][yy] == 'O' && ch[xx][yy] == 3) {
					put[nx][ny] = '.';
					ch[nx][ny] = 1;
				}
			}
		}
	}
}

void print(void) {
	for (int i = 0; i < x; ++i) {
		for (int j = 0; j < y; ++j) {
			cout << put[i][j];
		}
		cout << '\n';
	}
}

void ch_print(void) {
	for (int i = 0; i < x; ++i) {
		for (int j = 0; j < y; ++j) {
			cout << ch[i][j] << ' ';
		}
		cout << '\n';
	}
}

int main(void)
{
	input();
	while (n--) {
		search();
		//cout << n << endl;
		
		//ch_print();
	}
	print();
	

	return 0;
}


/*
if (xx == s1 && yy == s2) // *À» Ã£À¸¸é q µ¹¸±ÇÊ¿ä ¾ø´Ù.
{
while (!q.empty()) {
q.pop();
}
break;
}
*/
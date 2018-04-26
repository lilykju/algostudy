#include <iostream>
#include <string>
#define LEN 5
using namespace std;

const int dx[] = { 1,1,-1,-1,0,0,1,-1 };
const int dy[] = { 1,-1,1,-1,1,-1,0,0 };
char board[LEN][LEN];
bool inRange(int y, int x) {
	if (0 <= x && x <= LEN && 0 <= y && y <= LEN)
		return true;
	return false;
}
bool hasWord(int y, int x, const string& Word) {
	if (!inRange(y, x)) return false;
	if (board[y][x] != Word[0]) return false;
	if (Word.size() == 1) return true;

	for (int direc = 0; direc < 8; ++direc) {
		int nextY = y + dy[direc];
		int nextX = x + dx[direc];
		if (hasWord(nextY, nextX, Word.substr(1))) {
			return true;
		}
	}
	return false;
}

int main() {
	int t;
	cin >> t;
	while (t--) {
		for (int i = 0; i < LEN; ++i) {
			for (int j = 0; j < LEN; ++j) {
				cin >> board[j][i];
			}
		}
		int tt;
		cin >> tt;
		while (tt--) {
			string a;
			cin >> a;
			cout << (hasWord(0, 0, a) ? "YES" : "NO");
		}
	}
}
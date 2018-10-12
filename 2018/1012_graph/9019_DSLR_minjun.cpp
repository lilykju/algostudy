#include<iostream>
#include<queue>
#include<string>
#include<cstring>
using namespace std;

int visit[10001];
int D(int N) {
	return (N * 2) % 10000;
}

int S(int N) {
	if (N == 0)
		return 9999;
	return N - 1;
}

int L(int N) {
	int first = N % 1000;
	int second = N /1000;
	return first * 10 + second;
}

int R(int N) {
	int first = N / 10;
	int second = N % 10;
	return second * 1000 + first;
}
int main() {
	int T;
	scanf("%d", &T);
	for (int tc = 0; tc < T; tc++) {
		int a, b;
		int cnt = 0;
		scanf("%d %d", &a, &b);
		memset(visit, 0, sizeof(visit));
		queue<pair<int,string> > qu;
		qu.push({ a,"" });
		bool answer = false;
		while (!qu.empty()) {
			if (answer)
				break;
			int len = qu.size();
			for (int i = 0; i < len; i++) {
				int hereInt = qu.front().first;
				string hereString = qu.front().second;
				visit[hereInt] = 1;
				if (hereInt == b) {
					cout << hereString << endl;
					answer = true;
					break;
				}
				qu.pop();
				int DD = D(hereInt);
				int SS = S(hereInt);
				int LL = L(hereInt);
				int RR = R(hereInt);
				if (!visit[DD]) {
					qu.push({ DD, hereString + "D" });
					visit[DD] = 1;
				}
					
				if (!visit[SS]) {
					qu.push({ SS, hereString + "S" });
					visit[SS] = 1;
				}
					
				if (!visit[LL]) {
					qu.push({ LL, hereString + "L" });
					visit[LL] = 1;
				}
				
				if (!visit[RR]) {
					qu.push({ RR, hereString + "R" });
					visit[RR] = 1;
				}
					
			}
		}

	}
}

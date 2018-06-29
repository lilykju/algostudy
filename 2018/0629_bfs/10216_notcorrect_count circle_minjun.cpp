#include<iostream>
#include<vector>

using namespace std;
typedef pair<int, int> pii;
struct temp {
	int x, y, r;
};
int main() {
	int T;
	scanf("%d", &T);
	for (int testcase = 0;testcase < T;testcase++) {
		int N;
		scanf("%d", &N);
		vector<temp > arr[3003];
		int a, b, c;
		//scanf("%d %d %d", &a, &b, &c);
		//arr[0].push_back({ a,b,c });
		int cnt = 0;
		for (int i = 0;i < N;i++) {
			scanf("%d %d %d", &a, &b, &c);
			bool ans = false;
			for (int j = 0;j < cnt;j++) {
				if (ans)
					break;
				int len = arr[j].size();
				for (int z = 0;z < len;z++) {
					int hx = arr[j][z].x;
					int hy = arr[j][z].y;
					int hr = arr[j][z].r;
					if ((hx - a)*(hx - a) + (hy - b)*(hy - b) <= (c + hr)*(c + hr)) {
						arr[j].push_back({ a,b,c });
						ans = true;
						break;
					}
				}
			}
			if (ans)
				continue;
			else {
				arr[cnt].push_back({ a,b,c });
				cnt++;
			}
		}
		printf("%d\n", cnt);
	}
}

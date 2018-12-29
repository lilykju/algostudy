#include <iostream>
#include <vector>

using namespace std;

vector<int> v[501];
int visit[501] = { 0, };

void cnt(int now, int level) {
	if (level > 2)
		return;
	else
	{
		int next = 0;
		for (int i = 0; i < v[now].size(); i++) {
			next = v[now][i];
			visit[next] = 1;
			cnt(next, level+1);
		}
	}
}

int main() {

	int T;
	cin >> T;

	for (int testcase = 1; testcase <= T; testcase++) {

		int n, m;
		cin >> n >> m;

		for (int i = 0; i <= n; i++) {
			v[i].clear();
			visit[i] = 0;
		}

		int answer = 0;

		int a, b;
		for (int i = 0; i < m; i++) { //1 ≤ a ＜ b ≤ N
			cin >> a >> b;
			v[a].push_back(b);
            v[b].push_back(a);
		}

		if (v[1].size() == 0)
			answer = 0;
		else
		{
			cnt(1, 1);

			for (int i = 2; i <= n; i++)
				if (visit[i] == 1)
					answer++;
		}

		cout << '#' << testcase << ' ' << answer << endl;
	}

	return 0;
}

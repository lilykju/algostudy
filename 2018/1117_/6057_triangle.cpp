#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
#include <fstream>
#include <string>
#include <cstring>
#include <map>
#include <set>

#define pii pair<int, int>
#define pli pair<long, int>
#define mii map<int, int>
#define msi map<string, int>

typedef unsigned long long ull;
typedef long long ll;

using namespace std;

#define GO
#define DEBUG



vector<int> arr[51]; // 연결리스트
struct temp {
	int a, b, c;
};
set<vector<int>> ans;
bool visited[51];
vector<int> temp(3);

void go(int node, int start, int cnt,int first) {
	visited[node] = true;
	//cout << node << " cnt : " << cnt << endl;
	int len = arr[node].size();
	for (int i = 0; i < len; ++i) {
		int next = arr[node][i];
		if (cnt != 2 && node > next) {
			continue;
		}

		if (cnt == 2 && next == start) {
			//cout << "do " << endl;
			temp[0] = start;
			temp[1] = first;
			temp[2] = node;
				//	sort(temp.begin(), temp.end());
//			for (int i = 0; i < 3; ++i) {
	//			cout << temp[i] << ' ';
	//		}
	//		cout << endl;
			ans.insert(temp);
		}
		else if(visited[next] == false && cnt != 2) {
			//cout << "next : " << next << " start : " << start << endl;
			if (cnt == 0) {
				go(next, start, cnt + 1,first) ;
			}
			if (cnt == 1) {
				go(next, start, cnt + 1, node);
			}
		}
	}
	visited[node] = false;
}

int main(void) {
#ifdef GO
	freopen("input.txt", "r", stdin);
#endif
	int t;
	scanf("%d", &t);
	int ta, tb;
	for(int step = 1;step <= t; ++step){
		int n, m;
		scanf("%d %d", &n, &m);
		for (int i = 0; i < m; ++i) {
			scanf("%d %d", &ta, &tb);
			arr[tb].push_back(ta);
			arr[ta].push_back(tb);
		}

		//연결리스트 저장 끝
	
		//돌자
		for (int i = 1; i <= n; ++i) {
			//cout << "start : " << i << endl;
			memset(visited, false, sizeof(visited));
			go(i, i, 0, -1);
		}
		printf("#%d %d\n", step, ans.size());
		ans.clear();
		for (int i = 0; i <= n; ++i) {
			arr[i].clear();
		}
	}

	
#ifdef GO
	cout << "\nerase go\n";
#endif

	return 0;
}
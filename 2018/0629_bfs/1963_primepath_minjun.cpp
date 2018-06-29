#include<iostream>
#include<queue>
#include<string>
#include<cstring>
using namespace std;
string B;
int cnt;
int arr[10001];
int visit[10001];
void bfs(queue<string>& qu) {
	
	while (!qu.empty()) {
		int len = qu.size();
		cnt++;
		for (int i = 0;i < len;i++) {
			string here = qu.front();
			//cout << "이번에 방문은" << here << endl;
			qu.pop();
			if (here == B) {
				return;
			}
			
			for (int j = 0;j < 10;j++) {
				string temp1, temp2, temp3, temp4;
				temp1 = here;temp2 = here;temp3 = here;temp4 = here;
				temp1[0] = j + '0';
				temp2[1] = j + '0';
				temp3[2] = j + '0';
				temp4[3] = j + '0';
				/*cout << "추력"<<temp1 << " " << temp2 << " " << temp3 << " " << temp4 << endl;*/
				int n1 = atoi(temp1.c_str());
				int n2 = atoi(temp2.c_str());
				int n3 = atoi(temp3.c_str());
				int n4 = atoi(temp4.c_str());
				if (arr[n1] == 1 && visit[n1] == 0) {
					visit[n1] = 1;
					qu.push(temp1);
				}
				if (arr[n2] == 1 && visit[n2] == 0) {
				
					visit[n2] = 1;
					qu.push(temp2);
				}
				if (arr[n3] == 1 && visit[n3] == 0) {
					
					visit[n3] = 1;
					qu.push(temp3);
				}
				if (arr[n4] == 1 && visit[n4] == 0) {
					
					visit[n4] = 1;
					qu.push(temp4);
				}
			}
		}
	}
}
int main() {
	int T;
	scanf("%d", &T);
	for (int i = 2;i <= 10000;i++) {
		arr[i] = 1;
	}
	for (int i = 2;i <= 10000;i++) {
		if (arr[i] == 0)
			continue;
		for (int j = i * 2;j <= 10000;j += i) {
			arr[j] = 0;
		}
	}
	for (int i = 0;i < 1000;i++) {
		arr[i] = 0;
	}


	for (int testcase = 0;testcase < T;testcase++) {
		string A;
		cin >> A >> B;
		queue<string> qu;
		cnt = -1;
		memset(visit, 0, sizeof(visit));
		qu.push(A);
		bfs(qu);
		if (cnt == -1)
			printf("Impossible\n");
		else
			cout << cnt << endl;
	}
}

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{
	int t, n, k, w;
	int a, b;
	cin >> t;
	while (t--)
	{
		cin >> n >> k;
		vector<int> constructionT(n);
		vector<int> additionalT(n);
		vector<vector<int>> adjList(n);
		vector<int> indegree(n);
		for (int i = 0; i < n; i++)
		{
			cin >> constructionT[i];
		}
		while (k--)
		{
			cin >> a >> b;
			adjList[a - 1].push_back(b - 1);
			indegree[b - 1]++;
		}
		cin >> w;
		queue<int> sortedQ;
		for (int i = 0; i < n; i++)
		{
			//필요한 건물이 없을 경우 젤먼저 추가된다.
			if (indegree[i] == 0)
				sortedQ.push(i);
		}
		//w건물을 짓기위해 필요한 건물들이 남아있지않거나
		//sorting이 끝나면 while 탈출
		while (indegree[w - 1] && !sortedQ.empty())
		{
			int cur = sortedQ.front();
			sortedQ.pop();
			indegree[cur]--;
			for (int next : adjList[cur])
			{
				indegree[next]--;	//cur건물 시간 영향
				if (indegree[next] == 0)	//더 필요한 건물이 없을경우
					sortedQ.push(next);
				int curNeedT = constructionT[cur] + additionalT[cur];
				//cur 건설시간이 next의 추가건설시간보다 크면 next 추가건설시간은 cur 건설시간이된다.
				if (curNeedT > additionalT[next])
					additionalT[next] = curNeedT;
			}
		}
		cout << constructionT[w - 1] + additionalT[w - 1] << endl;
	}

	return 0;
}
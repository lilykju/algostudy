#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{
	int n, b;
	cin >> n;
	vector<int> constructionT(n);
	vector<int> additionalT(n);
	vector<vector<int>> adjList(n);
	vector<int> indegree(n);
	for (int i = 0; i < n; i++)
	{
		cin >> constructionT[i];
		cin >> b;
		while (b != -1)
		{
			adjList[b-1].push_back(i);	//b-1번째 건물 건설 후에 i건물을 지을수있다.
			indegree[i]++;	//i를 건설하기위해 필요한 건물 수(입력만)
			cin >> b;
		}
	}
	queue<int> sortedQ;	//i는 i건물 건설전 필요한 건물들(의 시간)확인이 필요 없을때만 Q에 들어갈수있다.
	for (int i = 0; i < n; i++)
	{
		//필요한 건물이 없을 경우 젤먼저 추가된다.
		if (indegree[i] == 0)
			sortedQ.push(i);
	}
	while (!sortedQ.empty())
	{
		//현재 큐 탐색
		int size = sortedQ.size();
		for (int j = 0; j < size; j++)
		{
			int cur = sortedQ.front();
			sortedQ.pop();
			indegree[cur]--;
			//next = cur건물이 필요한 건물들
			for(int next : adjList[cur])
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
	}
	for (int i = 0; i < n; i++)
		cout << constructionT[i] + additionalT[i] << endl;
	
	return 0;
}
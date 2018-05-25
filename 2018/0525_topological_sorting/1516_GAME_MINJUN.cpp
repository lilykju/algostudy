#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
#include<queue>

using namespace std;

int in[1002];

int main()
{
	int N;
	scanf("%d",&N);
	vector<int> arr(N+1);
	vector<int> topol[N+1];
	for(int i=1;i<=N;i++){
		scanf("%d",&arr[i]);
		while(1){
			int a;
			scanf("%d",&a);
			if(a==-1)
				break;
			topol[a].push_back(i);
			in[i]++;
		}	
	}
	queue<int> qu;
	vector<int> dist(N+1,0);
	for(int i=1;i<=N;i++){
		if(in[i]==0)
			qu.push(i);
			dist[i]=arr[i];
	}
	vector<int> ans;
	for(int i=1;i<=N;i++){
		int start=qu.front();
		qu.pop();
		ans.push_back(start);
		for(int j=0;j<topol[start].size();j++){
			int next=topol[start][j];
			if(dist[next] < dist[start] + arr[next])
				dist[next]=dist[start]+arr[next];
			if(--in[next]==0)
				qu.push(next);
		}
	}
	for(int i=1;i<=N;i++){
		cout<<dist[i]<<endl; 
	}
	
	
}


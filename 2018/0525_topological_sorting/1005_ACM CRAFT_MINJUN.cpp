#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
#include<queue>

using namespace std;

int main()
{
	int T;
	scanf("%d",&T);
	int in[1005];
	for(int testcase=0;testcase<T;testcase++){
		int N,K;
		memset(in,0,sizeof(in));
		scanf("%d %d",&N,&K);
		vector<int> price(N+1);
		vector<int> arr[N+1];
		for(int i=1;i<=N;i++){
			scanf("%d",&price[i]);
		}
		for(int i=0;i<K;i++){
			int a,b;
			scanf("%d %d",&a,&b);
			arr[a].push_back(b);
			in[b]++;
		}
		int W;
		scanf("%d",&W);
		queue<int> qu;
		int dist[1005];
		fill(dist,dist+1005,0);
		for(int i=1;i<=N;i++){
			if(in[i]==0){
				qu.push(i);
				dist[i]=price[i];
			}
		}		
		for(int i=0;i<N;i++){
			if(qu.empty())
				return !printf("-1");
			int here=qu.front();
			qu.pop();
			for(int j=0;j<arr[here].size();j++){
				int next=arr[here][j];
				if(dist[next] < dist[here]+price[next])
					dist[next]=dist[here]+price[next];
				if(--in[next]==0)
					qu.push(next);
			}
			
		}
		printf("%d\n",dist[W]);
		
	}
	
}


#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
#include<queue>

using namespace std;

int in[1002];

int main()
{
	int N,M;
	scanf("%d %d",&N,&M);
	vector<int> arr[N+1];
	queue<int> qu;
	for(int i=0;i<M;i++){
		int a;
		scanf("%d",&a);
	     int prev = 0;
	      for (int j = 0; j < a; j++)
	      {
	         int here;
	         scanf("%d", &here);
	         if (prev)
	         {
	            arr[prev].push_back(here);
	            in[here]++;
	         }
	         prev = here;
      	}
		
	}
	   for (int i = 1; i <= N; i++)
      if (!in[i])
         qu.push(i);
	vector<int> ans;
	
	for(int i=1;i<=N;i++){
		if(qu.empty()){
			return !printf("0");
		}
			int here=qu.front();
			qu.pop();
			ans.push_back(here);
			for(int j=0;j<arr[here].size();j++){
				int next=arr[here][j];
				if(--in[next]==0){
					qu.push(next);
				}
			}
		}
	
	for(int i=0;i<N;i++){
		printf("%d\n",ans[i]);
	}
	
}


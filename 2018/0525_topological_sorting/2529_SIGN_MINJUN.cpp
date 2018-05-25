#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>
#include<queue>
using namespace std;
int in[10];
int in2[10];
int main()
{
	int N;
	scanf("%d",&N);
	vector<char> sign(N);
	vector<int> arr[10];

	for(int i=0;i<N;i++){
		scanf("%s",&sign[i]);
		if(sign[i]=='<'){
			in[i+1]++;
			in2[i+1]++;
			arr[i].push_back(i+1);
		}
		else{
			in[i]++;
			in2[i]++;
			arr[i+1].push_back(i);
			
		}
	}
	priority_queue<int> min_qu;
	priority_queue<int> max_qu;
	for(int i=0;i<N+1;i++){
		if(in[i]==0){
			min_qu.push(-i);
			max_qu.push(i);
		}
	}

	vector<int> max_ans(10);
	int cnt=0;
	for(int i=0;i<N+1;i++){
		int here=max_qu.top();
		max_qu.pop();
		max_ans[here]=cnt++;
		for(int j=0;j<arr[here].size();j++){
			int next=arr[here][j];
			if(--in2[next]==0)
				max_qu.push(next);
		}
	}
	
	vector<int> min_ans(10);
	cnt=0;
	for(int i=0;i<N+1;i++){
		int here=-min_qu.top();
		min_qu.pop();
		min_ans[here]=cnt++;
		for(int j=0;j<arr[here].size();j++){
			int next=arr[here][j];
			if(--in[next]==0)
				min_qu.push(-next);
		}
	}
	for(int i=0;i<N+1;i++){
		printf("%d",max_ans[i]+9-N);
	}
	printf("\n");
	for(int i=0;i<N+1;i++){
		printf("%d",min_ans[i]);
	}

}



#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;
int dp[1001];

int main()
{
	int N;
	cin>>N;
	vector<int> box(N);
	for(int i=0;i<N;i++){
		cin>>box[i];
	}
	int mas=0;
	dp[N-1]=1;
	for(int i=N-2;i>=0;i--){
		for(int j=i+1;j<N;j++){
			if(box[i]<box[j] && dp[i]<dp[j])
				dp[i]=dp[j];
		}
		dp[i]++;
		mas=max(mas,dp[i]);
	}
	cout<<mas;
	
}



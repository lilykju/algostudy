#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<queue>
typedef long long ll;
using namespace std;
int dp[505][505];
int func(int x,int y,vector<int> & A){
	if(x==y)
		return 0;
	int &ret=dp[x][y];
	if(ret!=-1)
		return ret;
	
	int ans=1e9;
	for(int i=x;i<y;i++){
		ans=min(ans,func(x,i,A)+func(i+1,y,A));
		
	}
	for(int i=x;i<=y;i++){
		ans+=A[i];
		
	}
	return ret=ans;
}

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(NULL);
	int T;
	cin>>T;
	while(T--){
		int K;
		memset(dp,-1,sizeof(dp));
		cin>>K;
		vector<int> file(K);
		for(int i=0;i<K;i++){
			cin>>file[i];
		}
		cout<<func(0,K-1,file)<<endl;
		
	}	
	
	
}


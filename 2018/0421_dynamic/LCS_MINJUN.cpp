#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;
string A,B;
int dp[1001][1001];
int lenA,lenB;

int func(int x,int y){
	if(x==lenA || y==lenB){
		return 0;
	}
	int &ret =dp[x][y];
	if(ret!=-1)
		return ret;
	if(A[x]==B[y])
		return ret = 1+func(x+1,y+1);
	int mas=0;
	mas=func(x+1,y);
	mas=max(func(x,y+1),mas);
	
	return ret=mas;
}
int main()
{
	cin>>A>>B;
	memset(dp,-1,sizeof(dp));
	lenA=A.size();
	lenB=B.size();
	cout<<func(0,0);
	
}



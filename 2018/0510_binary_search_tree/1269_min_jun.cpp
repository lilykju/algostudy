#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int cntA,cntB;
	scanf("%d %d",&cntA , &cntB);
	vector<int> A(cntA);
	for(int i=0;i<cntA;i++){
		scanf("%d",&A[i]);
	}
	sort(A.begin(),A.end());
	int ans=0;
	for(int i=0;i<cntB;i++){
		int B;
		scanf("%d",&B);
		if(binary_search(A.begin(),A.end(),B))
			ans++;
	}
	printf("%d",cntA+cntB-ans*2);
}



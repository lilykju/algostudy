#include <iostream>
#include <vector>
#include <string>
#include<cstring>

using namespace std;

int max(int a,int b)
{
	if(a>b)
		return a;
	else
		return b;
}

int A[301];
int D[301];
int main()
{
	int n;
	cin>>n;
	
	
	for(int i=0; i<n; i++)
		cin>>A[i];
//	A[6]={10,20,15,25,10,20};
	D[0]=0;
	D[1]=A[0];
	D[2]=A[0]+A[1];
	for(int i=3;i<=n;i++)
		D[i]=A[i-1] + max(A[i-2]+D[i-3], D[i-2]);
	cout<<D[n];
}

#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int arr[6][6];

int sumarr(int a,int b)
{
	int sum=0;
	for(int i=a;i<a+3;i++)
		for(int j=b;j<b+3;j++)
			sum+=arr[i][j];
	sum=sum-arr[a+1][b]-arr[a+1][b+2];
	return sum;
}



int main()
{
	for(int i=0;i<6;i++)
	{
		for(int j=0;j<6;j++)
			cin>>arr[i][j];
	}
	int mas=-99990999;
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			int qqq=sumarr(i,j);
			
			if(mas<qqq)
				mas=qqq;
		}
	}
	cout<<mas;
}



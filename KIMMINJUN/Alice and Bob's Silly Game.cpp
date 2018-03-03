#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>

using namespace std;

int main()
{
	int g;
	int prime[100001];
	int n;
	cin>>g;
	for(int i=0;i<g;i++)
	{
		cin>>n;
		memset(prime,0,sizeof(prime));
		int cnt=0;
		for(int i=2;i*i<=n;i++)
		{
			if(prime[i]==0)
			{
				for(int j=i+i;j<=n;)
				{
					prime[j]=1;
					j=j+i;
				}
			}
		}
		for(int i=2;i<=n;i++)
		{
			if(prime[i]==0)
				cnt++;
		}
		if(cnt&1)
			cout<<"Alice"<<endl;
		else
			cout<<"Bob"<<endl;
		
					
	 } 
}


#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int k1,v1,k2,v2;
	cin>>k1>>v1>>k2>>v2;
	if(k1<k2)
	{
		swap(k1,k2);
		swap(v1,v2);
	}

	if( k1>k2 && v1>v2)
	{
		cout<<"NO"<<endl;
		return 0;
	}
	
	while(k2<=k1)
	{
		if(k2==k1)
		{
			cout<<"YES"<<endl;
			return 0;
		}
		
		k2+=v2;
		k1+=v1;
	}
	cout<<"NO"<<endl;
	
}



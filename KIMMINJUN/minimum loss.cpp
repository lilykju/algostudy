#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>

using namespace std;

int main()
{
	int N;
	cin>>N;
	vector<pair<long,int> > price(N);
	
	long mas=933013906376118;
	
	for(int i=0;i<N;i++)
	{
		int a;
		scanf("%d",&a);
		price[i].first=a;
		price[i].second=i;		
	}
	sort(price.begin(),price.end());
	for(int i=1;i<N;i++)
	{
		if((price[i].second-price[i-1].second)>0)
			continue;
		else
		{
			long aa=price[i].first-price[i-1].first;
			if(aa<mas)
				mas=aa;
		}
	}
	cout<<mas;

	
}



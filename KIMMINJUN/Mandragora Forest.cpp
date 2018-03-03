#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int T;
	cin>>T;
	for(int i=0;i<T;i++)
	{
		int N;
		cin>>N;
		vector<long> ganet(N);
		long sum=0;
		for(int i=0;i<N;i++)
		{
			cin>>ganet[i];
			sum+=ganet[i];
		}
		sort(ganet.begin(),ganet.end());
		long wow=1;
		long mas=0;
		long sel=0;
		for(int i=0;i<N;i++)
		{
			sel=sum*wow;
			if(sel>mas)
				mas=sel;
			wow++;
			sum-=ganet[i];
		}
		cout<<mas<<endl;
	}
	
}



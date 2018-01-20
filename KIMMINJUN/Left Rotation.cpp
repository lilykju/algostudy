#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int N;
	cin>>N;
	vector<int> wow(N);
	int d;
	cin>>d;
	for(int i=0;i<N;i++)
		cin>>wow[i];
	int cnt=N;
	while(cnt--)
	{
		cout<<wow[d++]<<" ";
		if(d==N)
			d=0;
		
	}
}



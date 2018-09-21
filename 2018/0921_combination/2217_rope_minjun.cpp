#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	int N;
	cin>>N;
	vector<int> rope(N);
	for(int i=0;i<N;i++)
	{
		cin>>rope[i];
	}
	sort(rope.begin(),rope.end());
	int mas=0;
	for(int i=0;i<N;i++)
	{
		int wow=rope[i]*(N-i);
		if(mas<wow)	
			mas=wow;
	}
	cout<<mas;
}

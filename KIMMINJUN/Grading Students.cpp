#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int N;
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int a;
		cin>>a;
		
		if(a<=37)
			cout<<a<<endl;
		else{
			if(a%5>2)
			{
				a+=(5-a%5);
				cout<<a<<endl;
			}
			else
				cout<<a<<endl;
		}
	}
}



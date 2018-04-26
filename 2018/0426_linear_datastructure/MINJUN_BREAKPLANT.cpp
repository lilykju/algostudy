#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;
 
bool arr[1000001];

int main()
{
	cin.tie(0);
	
	int N;
	cin>>N;
	vector<int> plant;//깨졌는지 판단 
	int cnt=0;
	for(int i=0;i<N;i++){
		int a,b,c;
		cin>>a>>b>>c;
		bool up=true;
		if(arr[a] || arr[b] || arr[c]){
			up=false;
		}
		arr[a]=1;
		arr[b]=1;
		arr[c]=1;
		if(up)
			cnt++;
	}
	cout<<cnt;
		
	
}



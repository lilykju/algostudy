#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int N;
	cin>>N;
	vector<int> arr(N);
	for(int i=0;i<N;i++){
		cin>>arr[i];
	}
	int start=arr[0];
	int end=arr[0];
	int ans=0;
	bool up=false;
	for(int i=1 ; i<N ; i++){
		
		if(arr[i] > arr[i-1]){
			end = arr[i];
			up=true;
		} 
		else{
			ans = max ( ans , (end-start) );
			end=arr[i];
			start = arr[i];
		}
	}
	ans = max ( ans , (end-start) );
	if(up)
		cout<<ans;
	else
		cout<<0;
}



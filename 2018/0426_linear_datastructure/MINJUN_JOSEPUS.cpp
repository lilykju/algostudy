#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
	int N,M;
	cin>>N>>M;
	vector<int> arr(N);
	for(int i=0;i<N;i++){
		arr[i]=i+1;
	}
	int pos=0;
	cout<<"<";
	while(1){
		pos=(pos+M-1)%(arr.size());
		cout<<arr[pos];
		if(arr.size()==1){
			break;	
		}
		cout<<", ";
		arr.erase(arr.begin()+pos);
		
	}
	cout<<">";
	
}



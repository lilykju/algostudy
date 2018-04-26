#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int cnt;
int arr[11][11];
bool istaken[11]; //false면 아직 조가 없고 true면 조가 정해졌다 

void cntfri(int N){
	int tostart=11; 
	for(int i=0;i<N;i++){
		if(!istaken[i]){
			tostart=i;
			break;
		}
	}
	
	if(tostart==11){
		cnt++;
		return ;
	}
	for(int i=tostart;i<N;i++){
		if(arr[tostart][i] && !istaken[i]){
			istaken[tostart]=true;
			istaken[i]=true;
			cntfri(N);
			istaken[i]=false;
			istaken[tostart]=false;
		}
	}
	
}

int main()
{
	int T;
	cin>>T;
	while(T--){
		cnt=0;
		memset(arr,0,sizeof(arr));
		memset(istaken,false,sizeof(istaken));
		int num,fri;
		cin>>num>>fri;
		for(int i=0;i<fri;i++){
			int a,b;
			cin>>a>>b;			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		cntfri(num);
		cout<<cnt<<endl;
		
		
	}
}

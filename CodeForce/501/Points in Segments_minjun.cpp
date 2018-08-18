#include<iostream>
#include<cstring>
using namespace std;

int main(){
    int N,M;
    scanf("%d %d",&N,&M);
    int arr[M+1];
    memset(arr,0,sizeof(arr));
    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        for(int j=a;j<=b;j++){
            arr[j]=1;
        }
    }
    int cnt=0;
    for(int i=1;i<=M;i++){
        if(arr[i]==0){
            cnt++;
        }
        
    }
    cout<<cnt<<endl;
    for(int i=1;i<=M;i++){
        if(arr[i]==0)
            cout<<i<<" ";
    }
    
    
}

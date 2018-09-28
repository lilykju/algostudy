

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int arr[27];
int main(){
    int N,K;
    scanf("%d %d",&N,&K);
    for(int i=0;i<N;i++){
        char x;
        cin>>x;
        arr[x-'a']=1;
        
    }
    int sum=0;
    for(int i=0;i<26;i++){
        if(arr[i]==1){
            sum+=i+1;
            i++;
            K--;
        }
        if(K==0)
            break;
    }
    if(K==0){
        cout<<sum+K;
    } else{
        cout<<-1;
    }
}

#include<iostream>
#include<string>
#include<map>

#define mod 1000000003
using namespace std;
int N,K;
int memo[1001][1001];


int first(int a,int cnt){
    if((a+1)/2<cnt)
        return 0;
    if(cnt==0){
        return 1;
    }
    if(a<=0)
        return 0;
    int& ret=memo[a][cnt];
    if(ret!=0)
        return ret;
    return ret=first(a-2,cnt-1)%mod+first(a-1,cnt)%mod;
}

int main(){
    scanf("%d %d",&N , &K);
    cout<<(first(N-3,K-1)%mod+first(N-1,K)%mod)%mod;
    
    
}

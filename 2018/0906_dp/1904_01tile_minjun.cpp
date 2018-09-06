#include <iostream>
#define mod 15746
using namespace std;
int arr[1000001];

int tile(int N){
    if(N==0)
        return 1;
    else if(N<0)
        return 0;
    int& ret=arr[N];
    if(ret!=0){
        return ret;
    }
    return ret=tile(N-2)%mod +tile(N-1)%mod;
}
int main(){
    int N;
    scanf("%d",&N);
    cout<<tile(N)%mod;
}

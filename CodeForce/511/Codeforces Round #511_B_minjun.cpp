#include<iostream>
#include<vector>

using namespace std;

int N,K,M;
int arr[1001][1001];


int main(){
    scanf("%d",&N);
    int mas=0;
    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        if(mas<a+b)
            mas=a+b;
    }
    cout<<mas;
    
}

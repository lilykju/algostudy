#include <iostream>
#include <vector>
using namespace std;

typedef pair<int,int>  pii;
typedef  long long  ll;

pii arr[100003];
ll memo[5][100003];

int N;


int dx[]={-1,0,1,0,0};
int dy[]={0,1,0,-1,0};
ll restaurent(int here,int cnt){
    if(cnt==N+2)
        return 0;
    
    
    int hereX=arr[cnt-1].first+dx[here];
    int hereY=arr[cnt-1].second+dy[here];
 
    ll& ret=memo[here][cnt];
    if(ret!=0)
        return ret;
    ll temp=922337203685477580;
    for(int i=0;i<5;i++){
        int nextX=arr[cnt].first+dx[i];
        int nextY=arr[cnt].second+dy[i];
        if(nextX>0 && nextX<=100000 &&nextY>0 && nextY<=100000){
            
             temp=min(temp,abs(nextX-hereX) + abs(nextY-hereY) + restaurent(i,cnt+1));
        }
    }

    return ret=temp;
}

int main(){

    cin>>N;
    for(int i=1;i<=N+1;i++){
        scanf("%d %d",&arr[i].first,&arr[i].second);
    }
    cout<<restaurent(4, 2);
    
}

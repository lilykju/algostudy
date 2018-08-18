#include<iostream>
#include<vector>
#include<map>

using namespace std;
typedef pair<int,int> pii;

int N,M;
pii arr[1100];
typedef long long ll;
ll car[1100][1100];
int visit[1100][1100];

ll police(int a, int b,int cnt){
    if(cnt==M+2)
        return 0;
    ll& ret=car[a][b];
    if(ret!=0){
        return ret;
    }
    int right= police(a,cnt,cnt+1)+abs(arr[b].first-arr[cnt].first)+abs(arr[b].second-arr[cnt].second);
    int left=police(cnt,b,cnt+1) +abs(arr[a].first-arr[cnt].first)+abs(arr[a].second-arr[cnt].second);
    ret=min(right,left);
    if(left<right)
        visit[a][b]=1;
    else
        visit[a][b]=2;
    return ret;
}

void tofind(int a,int b,int cnt){
    
    if(cnt==M+2)
        return;
    if(visit[a][b]==1){
        cout<<1<<endl;
        return tofind(cnt,b,cnt+1);
    }
    else{
        cout<<2<<endl;
        return tofind(a,cnt,cnt+1);
    }
}
int main(){
    cin>>N>>M;
    for(int i=2;i<M+2;i++){
        scanf("%d %d",&arr[i].first,&arr[i].second);
    }
    arr[0]={1,1};
    arr[1]={N,N};
    cout<<police(0,1,2)<<endl;
    tofind(0,1,2);
}

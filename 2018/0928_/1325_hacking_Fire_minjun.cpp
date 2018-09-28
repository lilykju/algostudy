//https://www.acmicpc.net/problem/1325

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
typedef pair<int,int> pii;
int visit[10001];
int result[10001];
vector<int> arr[10001];
int cnt;
int mas;
void dfs(int N ){
    visit[N]=1;
    cnt++;
    for(int i=0;i<arr[N].size();i++){
        if(visit[arr[N][i]])
            continue;
        dfs(arr[N][i]);
    }
}
int main(){
    int N,M;
    
    scanf("%d %d",&N,&M);
    
    
    for(int i=0;i<M;i++){
        int a,b;
        scanf("%d %d", &a,&b);
        arr[b].push_back(a);
    }
    for(int i=1;i<=N;i++){
        cnt=0;
        memset(visit,0,sizeof(visit));
        dfs(i);
        result[i]=cnt;
        if(cnt>mas)
            mas=cnt;
    }
    for(int i=1;i<=N;i++){
        if(result[i]==mas)
            printf("%d ",i);
    }
    
    
}

#include<iostream>
#include <algorithm>
#include<vector>
const int MAX =200;
using namespace std;

vector<int> arr[MAX];
bool visited[MAX];
int A[MAX],B[MAX];

bool dfs(int a){
    if(visited[a])
        return false;
    visited[a]=true;
    for(auto b : arr[a]){
        if(B[b]==-1 || dfs(B[b])){
            A[a]=b;
            B[b]=a;
            return true;
        }
    }
    return false;
    
}
int main(){
    int N,M;
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        int temp;
        scanf("%d",&temp);
        for(int j=0;j<temp;j++){
            int S;
            scanf("%d",&S);
            arr[i].push_back(S-1);
        }
    }
    fill(A,A+N,-1);
    fill(B,B+M,-1);
    int match=0;
    for(int i=0;i<N;i++){
        if(A[i]==-1){
            fill(visited,visited+N,0);
            if(dfs(i))
                match++;
        }
    }
    printf("%d",match);
    
}

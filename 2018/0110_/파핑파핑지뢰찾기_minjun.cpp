#include<iostream>
 
using namespace std;
int arr[301][301];
int N;
int totalCnt;
int dx[]={-1,-1,0,1,1,1,0,-1};
int dy[]={0,1,1,1,0,-1,-1,-1};
 
bool isRange(int x,int y){
    if(x>=0 && x<N && y>=0 && y<N){
        return true;
    }
    else{
        return false;
    }
}
 
int findMine(int x,int y){
    int cnt=0;
    for(int i=0;i<8;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(isRange(nx,ny)){
            if(arr[nx][ny]==-1){
                cnt++;
            }
        }
    }
    return cnt;
}
 
void setArr(){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(arr[i][j]==-1){
                continue;
            } else {
                arr[i][j] = findMine(i,j);
                if(arr[i][j]!=0){
                    totalCnt++;
                }
            }
        }
    }
}
 
void dfs(int x,int y){
    arr[x][y]=-10;
    for(int i=0;i<8;i++){
        int nx=dx[i]+x;
        int ny=dy[i]+y;
        if(isRange(nx,ny)){
            if(arr[nx][ny]==0){
                dfs(nx,ny);
            } else{
                arr[nx][ny]=-10;
            }
        }
    }
}
 
int findAns(){
    int cnt=0;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(arr[i][j]==0){
                arr[i][j]=-10;
                cnt++;
                dfs(i,j);
            }
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(arr[i][j]>0)
                cnt++;
        }
    }
    return cnt;
}
 
 
int main(){
    int t;
    cin>>t;
    for(int tc=1;tc<=t;tc++){
        N=0;
        cin>>N;
        for(int i=0;i<301;i++){
            for(int j=0;j<301;j++){
                arr[i][j]=0;
            }
        }
         
        for(int i=0;i<N;i++){
            char c;
            for(int j=0;j<N;j++){
                 
                scanf(" %c",&c);
                if(c=='.'){
                    arr[i][j]=-2;
                } else if(c=='*'){
                    arr[i][j]=-1;
                } else {
                    printf("무슨이런경우가...");
                }
            }
        }
 
        setArr();
        int ans = findAns();
        printf("#%d %d\n",tc,ans);
 
    }
}

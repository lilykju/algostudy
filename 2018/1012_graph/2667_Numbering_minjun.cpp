#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int arr[26][26];
int visit[26][26];
int N;
int dx[]={-1,0,1,0};
int dy[]={0,1,0,-1};
int ans;
void map(int x,int y){
    visit[x][y]=1;
    ans++;
    for(int i=0;i<4;i++){
        int nx=dx[i]+x;
        int ny=dy[i]+y;
        if(nx>=0 && ny>=0 && nx<N && ny<N){
            if(!visit[nx][ny] && arr[nx][ny]==1){
                map(nx,ny);
            }
        }
        
    }
}
int main(){
    
    scanf("%d",&N);
    vector<int> result;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            scanf("%1d",&arr[i][j]);
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(arr[i][j] && !visit[i][j]){
                ans=0;
                
                map(i,j);
                result.push_back(ans);
            }
        }
    }
    sort(result.begin(),result.end());
    cout<<result.size()<<endl;
    for(int i=0;i<result.size();i++){
        cout<<result[i]<<endl;
    }
}

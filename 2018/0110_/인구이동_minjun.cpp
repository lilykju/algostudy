#include<iostream>
#include<map>

using namespace std;
typedef pair<int,int> pii;

int N,L,R;
int arr[51][51];
int dx[]={-1,0,1,0};
int dy[]={0,1,0,-1};
int visit[51][51];
int country_cnt,country_cost, total_cnt=1;
int ans;
bool ismove=false;
map<int,pair<int,int> > mp;

bool inRange(pii x,pii y);
void bfs(int x,int y);

int main(){
    cin>>N>>L>>R;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            scanf("%d",&arr[i][j]);
        }
    }

    while(1){
        ismove=false;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                visit[i][j]=0;
            }
        }

        //같아질때까지 계속한다.
        total_cnt=1; //총 영역의 갯수
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j]==0){
                    bfs(i,j);
                    mp[total_cnt]={country_cnt,country_cost};
                    country_cost=0;
                    total_cnt++;
                    country_cnt=0;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                auto it = mp.find(visit[i][j]);
                int this_cnt = it->second.first;
                int this_cost = it->second.second;
                int change = this_cost/this_cnt;
//                cout<<i<<"행 "<<j<<" 열의 값은 : "<<change<<endl;
                if(arr[i][j]!=change){
                    ismove=true;
                }
                arr[i][j] =this_cost/this_cnt;
            }
        }
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                cout<<arr[i][j]<<" ";
//            }
//            cout<<endl;
//        }
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                cout<<visit[i][j]<<" ";
//            }
//            cout<<endl;
//        }
//        cout<<"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n";
        if(ismove==false){
//            cout<<"바로끝\n";
            break;
        }
        mp.clear();
        ans++;
    }

    printf("%d",ans);

}

void bfs(int x,int y){
    if(visit[x][y]!=0){
        return ;
    }
    visit[x][y]=total_cnt;

    country_cnt++;
    country_cost += arr[x][y];
    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];

        if(inRange({x,y}, {nx,ny})){
            bfs(nx,ny);
        }
    }
}


bool inRange(pii x,pii y){
    if(y.first>=0 && y.first<N && y.second>=0 && y.second<N){
        int temp = abs(arr[x.first][x.second]-arr[y.first][y.second]);
        if(temp>=L && temp<=R){

            return true;
        } else{
            return false;
        }
    } else {
        return false;
    }
}

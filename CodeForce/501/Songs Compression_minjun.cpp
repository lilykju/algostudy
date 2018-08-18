#include<iostream>
#include<cstring>
#include<vector>
#include<algorithm>

using namespace std;
typedef pair<int,int> pii;
typedef long long ll;
int main(){
    ll N,mas;
    cin>>N>>mas;
    vector<int> dis(N);
    ll mis=0;
    ll start=0;
    for(int i=0;i<N;i++){
        int a,b;
        cin>>a>>b;
        dis[i]=a-b;
        start+=a;
        mis+=b;
    }
    int tostop=mas;
    if(mas<mis){
        cout<<-1;return 0;
    }
    sort(dis.begin(),dis.end());
    int cnt=0;
    for(int i=N-1;i>=0;i--){
        if(start<=tostop){
            break;
        }
        start-=dis[i];
        
        cnt++;
    }
    cout<<cnt;
    
}

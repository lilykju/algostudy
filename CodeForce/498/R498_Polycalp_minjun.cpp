#include<iostream>
#include<vector>
#include<algorithm>
#include<map>

using namespace std;
typedef pair<int,int> pii;

bool comp(int a,int b){
    return a>b;
}
int main(){
    int N,K;
    scanf("%d %d",&N,&K);
    map<int,int> result;
    vector<int> temp(N);
    vector<int> arr(N);
    for(int i=0;i<N;i++){
        scanf("%d",&arr[i]);
        temp[i]=arr[i];
    }
    int total=0;
    sort(arr.begin(),arr.end(),comp);
    for(int i=0;i<K;i++){
//        cout<<arr[i]<<endl;
        result[arr[i]]++;
        total+=arr[i];
        
    }
    int cnt=0;
    int ans=0;
    cout<<total<<endl;

    for(int i=0;i<N;i++){
        
        if(cnt==K-1){
            cnt=i;
            break;
        }
        ans++;
        if(result[temp[i]]>0){
            cout<<ans<<" ";
            result[temp[i]]--;
            ans=0;
            cnt++;
        }
    }
    for(int i=cnt;i<N;i++){
        ans++;
    }
    cout<<ans<<endl;
    
}

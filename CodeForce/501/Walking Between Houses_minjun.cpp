#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
typedef long long ll;
bool comp(int a,int b){
    return a>b;
}
int main(){
    ll N,K,H;
    cin>>N>>K>>H;
    
    if((N-1)*K<H){
        cout<<"NO";
        return 0;
    }
    if(K>H){
        cout<<"NO";return 0;
    }
    cout<<"YES"<<endl;
    //H가 총 가야되는거리
    //K가 총 점프수
    //N 이 집의수
  
    H=H-K;//남은거리
    ll mas=N-2;
    vector<ll> arr(K,1);
    for(int i=0;i<K;i++){
        if(H>=mas){
            arr[i]+=mas;
            H-=mas;
        }
        else{
            
            if(H==0)
                arr[i]=1;
            else
                arr[i]+=H;
            break;
        }
    }
    sort(arr.begin(),arr.end(),comp);
    ll here=1;
    for(int i=0;i<K;i++){
        if(i%2==0){
            here=arr[i]+here;
            cout<<here<<" ";
        }
        else{
            here=here-arr[i];
            cout<<here<<" ";
        }
        
    }

}

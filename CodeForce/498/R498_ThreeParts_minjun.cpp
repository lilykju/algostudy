#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
typedef pair<int,int> pii;
typedef long long ll;
int main(){
    int N;
    scanf("%d",&N);
    vector<int> arr(N);
    for(int i=0;i<N;i++){
        scanf("%d",&arr[i]);
        
    }
    ll ans=0;
    ll Lresult=arr[0];
    ll Rresult=arr[N-1];
    int left=0;
    int right=N-1;
    while(left<right){
        if(Lresult==Rresult){
            ans=Lresult;
            left++;
            Lresult+=arr[left];
        }
        
        if(Rresult>Lresult){
            left++;
            Lresult+=arr[left];
        }
        
        else{
            right--;
            Rresult+=arr[right];
        }
        
    }
    cout<<ans;

}

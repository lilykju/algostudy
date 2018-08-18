#include<iostream>
#include<vector>

using namespace std;

int main(){
    int N,M;
    cin>>N>>M;
    vector<int> arr(N);
    int temp=0;
    for(int i=0;i<N;i++){
        scanf("%d",&arr[i]);
        temp+=arr[i];
        cout<<temp/M<<" ";
        temp=temp%M;
    }
    

    
}

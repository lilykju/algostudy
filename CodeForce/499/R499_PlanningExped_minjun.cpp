#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int arr[101];

int main(){
    int N,M;
    cin>>N>>M;
    for(int i=0;i<M;i++){
        int temp;
        scanf("%d",&temp);
        arr[temp]++;
    }
    vector<int> food;
    for(int i=0;i<101;i++){
        if(arr[i]){
            food.push_back(arr[i]);
        }
    }
    sort(food.begin(),food.end());
    int len=food.size();

    for(int i=101;i;i--){
        int sum=0;
        for(int j=len-1;j>-1;j--){
            sum+=food[j]/i;

        }
        
        if(sum>=N){
            cout<<i;
            return 0;
        }
    }
    cout<<0;
    
}

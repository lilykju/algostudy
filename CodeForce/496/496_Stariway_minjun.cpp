#include<iostream>
#include<vector>
using namespace std;

int main(){
    int N;
    scanf("%d",&N);
    int cnt=0;
    int before=0;
    vector<int> arr;
    for(int i=0;i<N;i++){
        int temp;
        scanf("%d",&temp);
        if(before<temp){
            before=temp;
            continue;
        }
        
        else{
            cnt++;
            arr.push_back(before);
            before=1;
        }
    }
    arr.push_back(before);
    cout<<arr.size()<<endl;
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}

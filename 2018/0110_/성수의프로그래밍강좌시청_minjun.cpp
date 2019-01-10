#include<iostream>
#include<vector>
#include<algorithm>
 
using namespace std;
int N,K;
 
int main(){
    int t;
    scanf("%d",&t);
    for(int tc=1;tc<=t;tc++){
        scanf("%d %d",&N,&K);
        vector<int> arr(N);
        for(int i=0;i<N;i++){
            scanf("%d",&arr[i]);
        }
        sort(arr.begin(),arr.end());
        int start = N-K;
        int end = N;
        double sum =0;
        for(int i=start;i<end;i++){
            sum+=arr[i];
            sum=sum/2;
        }
        printf("#%d %20.10lf\n",tc,sum);
    }
}

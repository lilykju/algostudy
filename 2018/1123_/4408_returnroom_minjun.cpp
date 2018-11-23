#include<iostream>
#include<cstring>

using namespace std;
typedef pair<int,int> pii;
int arr[401];

int main(){
    int T;
    scanf("%d",&T);
    for(int tc=1;tc<=T;tc++){
        int N;
        memset(arr,0,sizeof(arr));
        scanf("%d",&N);
        for(int i=0;i<N;i++){
            int a,b;
            scanf("%d %d",&a,&b);
            if(a>b)
                swap(a,b);
            for(int j= (a-1)/2 ;j<=((b-1)/2);j++){
                arr[j]++;
            }
        }
        int mas=0;
        for(int i=0;i<401;i++){
            if(mas<arr[i])
                mas=arr[i];
        }
        printf("#%d %d\n",tc,mas);
    }
}

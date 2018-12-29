#include <iostream>
#include <cstring>

using namespace std;
int arr[101];

int main(){
    int T;
    scanf("%d",&T);
    for(int t=0;t<T;t++){
        int a,b;
        memset(arr,0,sizeof(arr));
        scanf("%d %d",&a,&b);
        for(int i=0;i<b;i++){
            int temp;
            scanf("%d",&temp);
            arr[temp]++;
        }
        printf("#%d ",t+1);
        for(int i=1;i<=a;i++){
            if(!arr[i]){
                printf("%d ",i);
            }
        }
        printf("\n");
    }
    return 0;
}

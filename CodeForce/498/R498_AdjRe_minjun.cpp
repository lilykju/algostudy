#include<iostream>

using namespace std;

int main(){
    int N;
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        int temp;
        scanf("%d",&temp);
        if(temp%2==0)
            printf("%d ",temp-1);
        else
            printf("%d ",temp);
    }
    return 0;
    
}

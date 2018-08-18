#include<iostream>
#include<vector>
#include<cstring>

using namespace std;

int main(){
    int N,M,Q;
    cin>>N>>M>>Q;
    
    string A,B;
    cin>>A>>B;
    int lenA=A.size();
    int lenB=B.size();
    
    int ans[N+1];
    memset(ans,0,sizeof(ans));
    for(int i=0;i<=lenA-lenB;i++){
        if(A[i]==B[0]){
            bool tofind=false;
            for(int j=1;j<lenB;j++){
                if(A[i+j] == B[j]){
                    continue;
                }
                tofind=true;
                break;
            }
            if(!tofind)
                ans[i+1]=1;
        }
        
    }
    
    for(int i=0;i<Q;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        b=b-lenB+1;
        int cnt=0;
        for(int j=a;j<=b;j++){
            if(ans[j]==1)
                cnt++;
        }
        printf("%d\n",cnt);
    }
    
}

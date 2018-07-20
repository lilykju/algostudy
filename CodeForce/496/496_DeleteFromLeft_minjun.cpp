#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main(){
    string A,B;
    cin>>A>>B;
    int lenA=A.size();
    int lenB=B.size();
    int cntA=lenA-1;
    int cntB=lenB-1;
    int ans=0;
    for(int i=0;;i++){
        if(cntA<0 || cntB<0)
            break;
        if(A[cntA]==B[cntB]){
            ans++;
        }
        else
            break;
        
        cntA--;
        cntB--;
        
        
    }

    cout<<(lenA+lenB-ans*2);
    return 0;
}

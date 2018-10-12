#include<iostream>
#include<vector>

using namespace std;

int N,K,M;
int arr[1001][1001];


int main(){
    scanf("%d",&N);
    int temp=N/3;
    if(N%3==0){
        
        if(temp%3==0){
            cout<<temp-2<<" "<<temp+1<<" "<<temp+1<<endl;
        }
        else{
            cout<<temp<<" "<<temp<<" "<<temp;
        }
    }else if(N%3==1){
        if(temp%3==0){
            cout<<temp-1<<" "<<temp+1<<" "<<temp+1;
        }
        else if(temp%3==1){
            cout<<temp<<" "<<temp<<" "<<temp+1;
        }else {
            cout<<temp-1<<" "<<temp<<" "<<temp+2;
        }
    }else if(N%3==2){
        if(temp%3==0){
            cout<<temp-2<<" "<<temp+2<<" "<<temp+2;
        }
        else if(temp%3==1){
            cout<<temp<<" "<<temp+1<<" "<<temp+1;
        }
        else{
            cout<<temp<<" "<<temp<<" "<<temp+2;

        }
    }
    
}

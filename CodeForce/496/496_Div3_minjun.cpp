#include<iostream>

using namespace std;

int main(){
    string A;
    cin>>A;
    int len=A.size();
    int cnt=0;
    int temp=0;
    int tempcnt=0;
    for(int i=0;i<len;i++){
        int here=A[i]-'0';
        if(here%3==0){
            cnt++;
            temp=0;
            tempcnt=0;
            continue;
        }
        if(tempcnt==0){
            tempcnt++;
            temp+=here;
        }
        else if(tempcnt==1){
            if((temp+here)%3==0){
                cnt++;
                temp=0;
                tempcnt=0;
            }
            else{
                tempcnt++;
            }
        }
        else{
            cnt++;
            temp=0;
            tempcnt=0;
        }
    }
    cout<<cnt;
}

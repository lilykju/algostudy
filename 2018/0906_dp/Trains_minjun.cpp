#include<iostream>
#include<vector>

using namespace std;
typedef long long ll;
ll gcd(ll a,ll b)
{
    ll c;
    while (b != 0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}
ll lcm(ll a, ll b)
{
    return a * b / gcd(a, b);
}
int main(){
    int N,M;
    scanf("%d %d",&N,&M);
    ll gc= lcm(N,M);
//    cout<<"gc : "<<gc<<endl;
    ll left=gc/N;
    ll right=gc/M;
    
    if(abs(left-right)<2){
        cout<<"Equal";
    }
    else if(left>right){
        cout<<"Dasha";
    }
    else
        cout<<"Masha";
    
}
//http://codeforces.com/contest/87/problem/A

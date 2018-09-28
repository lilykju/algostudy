//https://www.acmicpc.net/problem/1946

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
typedef pair<int,int> pii;


int main(){
    int T;
    scanf("%d",&T);
    for(int tc=0;tc<T;tc++){
        int N;
        scanf("%d",&N);
        vector<pii> person(N);
        for(int i=0;i<N;i++){
            int a,b;
            scanf("%d %d",&a, &b);
            person[i].first=N-a;
            person[i].second=N-b;
        }
        
        sort(person.begin(),person.end());
        int sum =0;
        int temp=person[0].first;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(person[i].second<person[j].second){
                    sum++;
                    break;
                }
            }
            
        }
        printf("%d\n",N-sum);
    }
    
}

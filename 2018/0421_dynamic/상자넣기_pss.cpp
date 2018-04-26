#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>

using namespace std;

int n;
int tb1[1001];
int che1[1001];

int go(int idx)
{
 	if(idx == n){
		return 0;
	}

	int& ret = che1[idx];
	if (ret != -1) 
		return ret;
	ret = 1;
	for(int i = idx+1; i<n;++i){
		if(tb1[idx]<tb1[i]){
			ret = max(ret, go(i) + 1);
		}
	}
  	
	return ret;
}

int main(void)
{
	cin >> n;
	for(int i=0;i<n;++i){
		cin >> tb1[i];
	}
	
	memset(che1,-1,sizeof(che1));
	int ans = 0;
	for(int i=0;i<n;++i){
		ans = max(ans,go(i));
	}
	
	cout << ans << endl;
	
	
}

/* 
시간복잡도 
main for문 n
재귀 함수 n
재귀 함수 안의 n 
O(n^3) 이지만 memoization 덕분에 훨신 적다. 

공간복잡도 cache 1001 * 2 바이트 


풀이
go 함수는 idx를 주면 그 idx를 시작점으로 해서 
LIS 를 구한다. 

main의 for로 모든 idx 를 넣어주면 모든 경우를 다 해볼 수 있다. 



*/

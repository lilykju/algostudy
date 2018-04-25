#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>

using namespace std;

string a,b;
int alen;
int blen;
int cache[1001][1001];

int go(int i, int j)
{
	if(i == alen || j == blen){
		return 0;
	}

	int& ret = cache[i][j];
	if (ret != -1) 
		return ret;
	
	ret = 0;
  	if (a[i] == b[j]) 
  		ret = 1 + go(i+1, j+1);
    else 
    	ret = max(go(i+1, j), go(i, j+1));
	
	return ret;
}

int main(void)
{
	memset(cache,-1,sizeof(cache));
	cin >> a >> b;
	alen = a.size();
	blen = b.size();

	cout << go(0,0) << endl;
}

/* 
시간복잡도 O(max(a.size,b.size))?
공간복잡도 string 2개 + cache 1001^2 바이트 

의문 
if(i == alen || j == blen){
		return 0;
	}
이렇게 말고
if(a[i] == '\0' || ~~){
	
}
로 했는데 왜 제대로 안 될까. 
풀이

나눌수 있는 case는 
1. i, j 로 탐색하면서 문자가 일치할 때
2. 일치하지 않을때.

1. 일치하면 return 값에 1 더해주고 둘다 그 다음 글자를 탐색
2. 일치하지 않으면 a만 증가시킨것과 b만증가시킨것을 구한다. 그중 큰 값을 구하는 문제이므로 max


*/

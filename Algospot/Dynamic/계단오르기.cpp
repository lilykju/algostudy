#include <iostream>
#include <algorithm>

using namespace std;

int tb1[301];
int d[301][2];
int main(void)
{
	int n;
	cin >> n;
	for(int i=1;i<=n;++i){
		cin >> tb1[i];
	}
	d[0][0] = 0;
	d[0][1] = 0;
	d[1][0] = tb1[1];
	d[1][1] = tb1[1];
	//cout << tb1[0] << ' ' << tb1[0] << endl;
	for(int i=2;i<=n;++i){
		d[i][0] = max(d[i-2][1],d[i-2][0]) + tb1[i];
		d[i][1] = d[i-1][0] + tb1[i];
		//cout <<"I : "<< i << ' ' << d[i][0] << ' ' << d[i][1] << endl;
	}
	cout << max(d[n][0],d[n][1]) << endl;
	return 0;
}

/* 
시간복잡도 O(n)?
공간복잡도 int인 n * 3; 최대 301 * 3 = 906바이트 정도

풀이

n번째 계단을 밟으려면 경우의 수는 2가지 
1. 바로앞에서 1개를 밟고 온다.
2. 2칸 저에서 1개나 2개를 밟고 온다. 

d[x][0] => x계단만 밟은 상태
d[x][1] => x계단과 그 바로전의 계단을 밟은 상태 

1. 의 구현
d[n][1] =d[n-1][0] + tb1[i] 
한칸 전에서 밟고 d[n][1]을 밟을 수 있는 방법은 이전에 계단을 밟았던 방법이 x계단만 밟은 상태여야 한다.

2. 의 구현
d[n][0] = max(d[i-2][1],d[i-2][0]) + tb1[i];
두칸 전에서 밟고 d[n][0] 을 밟을 방법은 2칸전에 밟았던 방법 모두이다. 그중 큰 것 으로 


*/

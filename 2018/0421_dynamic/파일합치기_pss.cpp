#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <limits.h>
#include <queue>
#include <stack>
#include <vector>

using namespace std;

int tb1[100001];
int tb2[1001][1001];
int che[100001];
int che2[1001][1001];
int sum[1001];
int n, m;

int min3(int a,int b,int c){
	a = (a < b ? a : b);
	return (a < c ? a : c);
}

int go(int s,int e) {
	if (che2[s][e] != 0x3f3f3f3f) {
		return che2[s][e];
	}
	if (s == e) {
		return che2[s][e] = 0;
	}
	if (s + 1 == e) {
		return che2[s][e] = tb1[s] + tb1[e];
	}
	
	for (int i = s; i < e; ++i) {
		int left = go(s, i);
		int right = go(i+1, e);
		che2[s][e] = min(che2[s][e], left + right);
	}
	return che2[s][e] += sum[e] - sum[s-1];
}




int main(void)
{
	int t;
	cin >> t;
	while (t--) {
		memset(che2, 0x3f, sizeof(che2));
		cin >> n;
		for (int i = 1; i <= n; ++i) {
			cin >> tb1[i];
			sum[i] = sum[i - 1] + tb1[i];
		}
		cout << go(1, n) << '\n';
	}

	
	return 0;
}
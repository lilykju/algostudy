#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
	int n,lastAnswer=0,q;
	cin >> n >> q;
	vector<int> seqList[100001];
	while (q--) {
		int a, x, y,push;
		cin >> a >> x >> y;
		
		push = (x ^ lastAnswer) % n;
		if (a == 1) {
			seqList[push].push_back(y);
		}
		if (a == 2) {
			lastAnswer = seqList[push][y%seqList[push].size()];
			cout << lastAnswer << '\n';
		}
		
	}
	/*cout << seqList0.size() << ' ' << seqList1.size() << '\n';
	for (int i = 0; i < seqList0.size(); ++i) {
		cout << seqList0[i] << ' ';
	}
	cout << '\n';
	for (int i = 0; i < seqList1.size(); ++i) {
		cout << seqList1[i] << ' ';
	}*/
	
	return 0;
}

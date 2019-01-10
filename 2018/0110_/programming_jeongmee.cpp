#include <iostream>
#include <algorithm>

using namespace std;

int main(){
	
	int T;
	cin >> T;
	
	for(int testcase = 1; testcase <= T; testcase++){
		
		int n, k;
		cin >> n >> k;
		
		int mn[10000] = {0, };
		
		for(int i = 0; i < n; i++){
			cin >> mn[i];
		}
		
		sort(mn, mn+n);
		
		float now = 0, pre = 0;
		
		for(int i = n-k; i <= n-1; i++){
			
			pre = now;
			now = (pre + mn[i])/2;
		}
		
		cout << '#' << testcase << ' ' << now << endl;
		
	}
	
	return 0;
}

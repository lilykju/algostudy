#include <iostream>

using namespace std;

int a[100001];
int n, range;

void input(void){
	cin >> n >> range;
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
}
int ans = 0;
bool fail = false;

void search(void) {
	int i, j;
	for (i = range - 1; i < n; i += range*2-1) {
		//cout << "i = " << i << endl;
		for (j = 0; j < range*2; ++j) {
			//cout << "what j = " << j << "ans = " << ans <<  endl;
			if (a[i - j] == 1) {
				++ans;
				//cout << "i-j : " << i - j << endl;
				//cout << "ans: " << ans << endl;	
				i = (i - j);
				break;
			}
		}
		if (j == range*2) {
			fail = true;
			break;
		}
	}
	int focal = n - 1 - (i - (range * 2 - 1)) - (range - 1);
	//cout << "n : " << n << endl;
	//cout << "i : " << i << endl;
	//cout << "i - (range * 2 - 1) : " << (i - (range * 2 - 1)) << endl;
	//cout << "focal : " << focal << endl;
	if (focal > 0) { 
		int k;
		for (k = n-range; k < n; ++k) {
			//cout << "circle k " << k << endl;
			if (a[k] == 1) {
				++ans;
				break;
			}
		}
		if (k == n) {
			fail = true;
		}
	}
}

int main(void)
{
	input();
	search();
	cout << (fail ? -1 : ans);
	return 0;
}
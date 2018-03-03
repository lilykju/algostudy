#include <iostream>
#include <algorithm>

using namespace std;

bool b[200001];
int main(void)
{
	int n, k;
	cin >> n >> k;
	int pmax = 0;
	for (int i = 0; i < n; ++i) {
		int p;
		cin >> p;
		b[p] = true;
		pmax = max(pmax, p);
	}
	int cnt = 0, j,i = 1;;
	while(i<=pmax){
		if (b[i] == true) {
			cnt++;
			for (j = i + k ; ; --j) {
				if (b[j] == true) {
					i = j+k;
					break;
				}
			}
		}
		i++;
	}
	cout << cnt;
	return 0;

}

#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{
	int n;
	cin >> n;
	int a[100001];
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	sort(a, a + n);
	int min = 999999999;
	for (int i = 1; i < n; ++i) {
		int temp = abs(a[i] - a[i - 1]);
		if (min > temp)
			min = temp;
		
	}
	cout << min;
	return 0;
}
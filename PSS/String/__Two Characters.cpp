#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int n;
	string ln;
	cin >> n >> ln;
	int i;
	char first;
	for (i = 0; i < n; ++i) {
		if (ln[i] == ln[i + 1]) {
			first = ln[i];
			break;
		}
	}
	int max = i+1;
	i = 0;
	while (ln[i] == ln[i + 1]) {
		for (; i < n && ln[i] != first; ++i) {
			if (ln[i] == ln[i + 1]) {
				break;
			}
		}
	}
	if (max < i + 1)
		max = i + 1;
	cout << max << endl;
	return 0;

	
}
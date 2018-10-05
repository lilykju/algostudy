#include<iostream>
#include<string>
#include<vector>

using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	string pattern;
	cin >> pattern;
	int star = 0;
	int len = pattern.size();
	for (int i = 0; i < len; i++) {
		if (pattern[i] == '*') {
			star = i;
			break;
		}
	}

	int first = star;
	int second = len - star - 1;
	
	string temp;
	for (int i = 0; i < N; i++) {

		bool ans = true;
		cin >> temp;
		int templen = temp.size();
		if (templen < first+second) {
			cout << "NE\n";
			ans = false;
		} else {
			for (int j = 0; j < first; j++) {
				if (temp[j] != pattern[j]) {
					ans = false;
					break;
				}
			}
			
			if (ans) {
				for (int j = 0; j < second; j++) {
					if (temp[templen - j - 1] != pattern[len - j - 1]) {
						ans = false;
						break;
					}
				}
			}
			if (ans) {
				cout << "DA\n";
			}
			else {
				cout << "NE\n";
			}
		}


	}


}

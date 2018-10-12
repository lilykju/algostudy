#include <iostream>
#include <vector>
#include<string>
using namespace std;

int main() {
	string A, B;
	cin >> A >> B;
	int lenA = A.size();
	int lenB = B.size();

	int mis = 505;
	
	for (int i = 0; i <= lenB - lenA; i++) {
		int cnt = 0;
		
		for (int j = 0; j < lenA; j++) {
			if (A[j] != B[j+i]) {
				
				cnt++;
			}
			if (cnt >= mis)
				break;
		}
		if (cnt < mis)
			mis = cnt;
		
	}
	cout << mis;

}

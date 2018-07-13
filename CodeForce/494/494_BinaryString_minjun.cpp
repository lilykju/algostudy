#include<iostream>
#include<string>
using namespace std;

int main() {
	int a, b, x;
	scanf("%d %d %d", &a, &b, &x);
	string total = "";
	string first;
	string second;;
	if (a >= b) {
		first = "0";
		second = "1";
	}
	else {
		swap(a, b);
		first = "1";
		second = "0";
	}
	total = first + second;
	a--; b--; x--;
	bool s = true;
	while (x > 0) {
		if (s) {
			if (a == 0) {
				total = second + total;
				b--;
				break;
			}
			else {
				total += first;
				a--;
			}
		}
		else {
			if (b == 0) {
				
				total = first + total;
				a--;
				break;
			}
			else {
				total += second;
				b--;
			}
		}
		s = !s;
		x--;
	}

	int len = total.size();
	for (int i = 0; i < len; i++) {
		printf("%c", total[i]);
		if (total[i] == first[0]) {
			for (int j = 0; j < a; j++)
				printf("%c", first[0]);
			first[0] = 'x';
		}
		if (total[i] == second[0]) {
			for (int j = 0; j < b; j++) {
				printf("%c", second[0]);
			}
			second[0] = 'x';
		}

		
	}
}

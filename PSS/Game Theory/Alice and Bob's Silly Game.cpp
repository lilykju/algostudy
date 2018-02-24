#include <iostream>

using namespace std;


bool c[100001];
void cal_prime_num() {
	for (int i = 2; i <= 100001; ++i) {
		if (c[i] == false) {
			for (int j = i * 2; j <= 100001; j += i) {
				//이론상으로는 j=i*i가 맞으나 정수 오버플로우가 발생할 수 있음.
				//j*2를 하면 이미 지웠던 것을 또 지우게 되지만 문제는 없으므로.
				c[j] = true;
			}
		}
	}
}

int d[100001];
void cal_x_primecnt() {
	d[1] = 0;
	for (int i = 2; i <= 100001; ++i) {
		d[i] = d[i - 1];
		if (c[i] == false) {
			d[i]++;
		}
	}
}

int main(void)
{
	cal_prime_num();
	cal_x_primecnt();
	int t;
	cin >> t;
	while (t--) {
		int k;
		cin >> k;
		cout << (!(d[k] % 2) ? "Bob\n" : "Alice\n");
	}
	return 0;
}
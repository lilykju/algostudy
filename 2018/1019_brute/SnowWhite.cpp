#include<iostream>
#include<algorithm>
using namespace std;

#define N 9
#define MAX 100

int bf(int *arr) {
	int sum = 0;
	for (int i = 0; i < N; i++) {
		sum += arr[i];
	}

	for (int i = 0; i < N - 1; i++) {
		for (int j = i + 1; j < N; j++) {
			if (sum - arr[i] - arr[j] == MAX) {
				arr[i] = 0;
				arr[j] = 0;
				return 0;
			}
		}
	}

}

int main() {

	int a[N];
	for (int i = 0; i < N; i++)
		cin >> a[i];

	bf(a);
	sort(a, a + N);

	for (int i = 2; i < N; i++) {
		cout << a[i] << endl;
	}

	return 0;
}
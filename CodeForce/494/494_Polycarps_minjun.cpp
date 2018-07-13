#include<iostream>
#include<cstring>
using namespace std;
int arr[101];
int main() {
	int N;
	scanf("%d", &N);
	memset(arr, 0, sizeof(arr));
	int mas = 0;
	for (int i = 0; i < N; i++) {
		int temp = 0;
		scanf("%d", &temp);
		arr[temp]++;
		if (mas < arr[temp])
			mas = arr[temp];
	}
	printf("%d", mas);

}

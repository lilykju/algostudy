//#include <Windows.h>
#include <stdio.h>
#include <iostream>
#include <algorithm>

using namespace std;

double arr[201] = { 0.0, };
double result;

/*  순열시도  --------------> 시간 초과   */
//void swap(double *a, double *b) {
//	double tmp;
//	tmp = *a;
//	*a = *b;
//	*b = tmp;
//}
//
//void print_arr(int size) {
//	for (int i = 0; i < size; ++i)
//		cout << arr[i] << " ";
//	cout << endl;
//}
//
//void permutation(int n, int r, int depth) {
//	int i;
//
//	if (r == depth) {
//		cal(depth);
//		//print_arr(depth);
//		return;
//	}
//
//	for (i = depth; i < n; ++i) {
//		swap(&arr[i], &arr[depth]);
//		permutation(n, r, depth + 1);
//		swap(&arr[i], &arr[depth]);
//	}
//
//}
/*  --------------------------------------------------------- */


bool desc(double a, double b) {
	return a > b;
}


void cal(int size) {
	double part = 0.0;

	for (int i = size-1; i >= 0; --i) {
		part = (part + arr[i]) / 2.0;
		//cout << "part: " << part << endl;
	}

	if (part > result)
		result = part;
}



void Initialize(istream& is, int N)
{
	double data;
	for (int i = 0; i < N; ++i) {
		cin >> data;
		arr[i] = data;
	}
}

void processing(int i, istream& is, ostream& os)
{
	
	int N, K; 
	is >> N >> K;
	
	Initialize(is,  N);
	//permutation(N, K, 0);
	sort(arr, arr + N, desc);
	cal(K);

	printf("#%d %f\n", i, result);


}

int main()
{
	int T;
	cin >> T;
	for (int i = 1; i <= T; ++i) {
		result = 0;
		processing(i, cin, cout);
	}

	//system("pause");
	return 0;
}
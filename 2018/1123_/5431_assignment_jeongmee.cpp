#include <iostream>

using namespace std;

int main(int argc, char** argv) {
	
	int testcase = 0;
	cin >> testcase;
	
	for(int t = 1; t <= testcase; t++){
		
		int arr[101] = {0, };
		int n, k;
		cin >> n >> k;
		
		for(int i = 0; i < k; i++){
			int x;
			cin >> x;
			arr[x] = 1;
		}
		
		cout << '#' << t;
		
		for(int i = 1; i <= n; i++){
			if(arr[i] != 1)
				cout << ' ' << i;
		}
		
		cout << endl;
	}

	return 0;
}

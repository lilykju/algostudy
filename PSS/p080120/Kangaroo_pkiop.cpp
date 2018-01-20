/*
	숫자 입력 받은 다음 두 캥거루의 처음위치차이를 gap에 저장,
	만약 서로 가까워 지지 않는다면 gap보다 x2-x1이 커질 것.
	가까워진다고 해도 x1==x2인 지점을 지나친다면 결국 gap보다 x2-x1이 커진다.
	while로 gap보다 x2-x1이 커지면 실패이므로 NO
	x2==x1이 되면 while이 끝나고 YES

	위치는 다른데 증가량이 같은 경우에는 이 while문에서 파악할 수 없으므로
	이 경우는 따로 NO로 지정

	시간복잡도 O(x2-x1+(v1,v2중에 작은 것)) => O(1)
	공간복잡도 5byte?
*/

#include <iostream>
#include <string>

using namespace std;

string kangaroo(int x1, int v1, int x2, int v2) {
	if (x1 != x2 && v1 == v2) {
		return "NO";
	}
	int gap = x2 - x1;
	
	while (gap >= x2 - x1 && x1 != x2) {
		x1 += v1;
		x2 += v2;
	}
	if (x1 == x2) {
		return "YES";
	}
	else {
		return "NO";
	}
}

int main() {
	int x1;
	int v1;
	int x2;
	int v2;
	cin >> x1 >> v1 >> x2 >> v2;
	string result = kangaroo(x1, v1, x2, v2);
	cout << result << endl;
	return 0;
}

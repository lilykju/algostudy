// 180203_GoodlandElectricity.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include <iostream>
#include <vector>

using namespace std;

int pylons(int k, vector <int> arr) {
	// Complete this function
	int curIdx = 0;
	int count = 0;
	bool isContinue = false;
	while (curIdx < arr.size())
	{
		//cout << curIdx << endl;
		if (arr[curIdx] == 1)
		{
			curIdx++;
			continue;
		}
		int jump = k-1;
		isContinue = false;
		for (jump; curIdx+ jump >curIdx-k; jump--)
		{
			if (curIdx + jump >= arr.size())
			{
				continue;
			}
			if (curIdx + jump < 0)
			{
				break;
			}
			if (arr[curIdx + jump] == 1)
			{
				curIdx = curIdx + jump + k;
				count += 1;
				isContinue = true;
				break;
			}
		}
		if(isContinue!=true) return -1;
		
	}
	return count;
}

int main() {
	int n;
	int k;
	cin >> n >> k;
	vector<int> arr(n);
	for (int arr_i = 0; arr_i < n; arr_i++) {
		cin >> arr[arr_i];
	}
	int result = pylons(k, arr);
	cout << result << endl;
	return 0;
}
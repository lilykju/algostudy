// 180303_candy.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//


#include <iostream>
#include <vector>

using namespace std;
/*
a=1~n-1까지 학생중 제일 많은 사탕을 가진 학생의 idx
f(n)= f(n-1)+ a~n-1까지 사탕한개씩더주고 n번째 학생은 사탕한개
<-if n이 n-1보다 작을때

f(n)=f(n-1)+n-1의 사탕갯수+1
<-if n이 n-1보다 클때
*/
int candies(int n, vector <int> arr) {
	// Complete this function
	vector<int> arr_result(n);
	arr_result[0] = 1;
	int highIdx = 0;
	for (int i = 1; i < n; i++)
	{
		//새로운 i가 i-1의 점수보다 클 경우
		if (arr[i] > arr[i - 1])
		{
			highIdx = i;	//
			arr_result[i] = arr_result[i - 1] + 1;
		}
		//작은 값이 들어올 경우 
		//case 1: i-1이 1이 아닐때
		//case 2:i-1이 1일때..한칸씩 앞으로 탐색하였을 때 높이 올라갔을 때의 값?
		//	case 2-1: i-1과 i가 같을경우 
		//	case 2-2: 다를경우
		else
		{
			//case 1
			if (arr_result[i - 1] != 1)
			{
				arr_result[i] = 1;
			}
			//case 2
			else
			{
				if (arr[i - 1] == arr[i])	//case 2-1
				{
					arr_result[i] = arr_result[i-1];
				}
				else //case 2-2
				{
					//뒷부분 내림차순인 부분만 check
					for (int j = i-1; j >= highIdx; j--)
					{
						arr_result[j] += 1;
						//j에 사탕 한개를 더줘도 내림차순에 위배되지 않을 경우
						if (arr_result[j] < arr_result[j - 1]|| arr[j] == arr[j - 1])
						{
							break;
						}
					}
					//arr_result[i - highIdx] = 1;
					arr_result[i] = 1;
				}
			}
		}
	}
	int result = 0;
	for (int i = 0; i < n; i++)
	{
		//cout << arr_result[i] << endl;
		result += arr_result[i];
	}
	return result;
}

int main() {
	int n;
	cin >> n;
	vector<int> arr(n);
	for (int arr_i = 0; arr_i < n; arr_i++) {
		cin >> arr[arr_i];
	}
	int result = candies(n, arr);
	cout << result << endl;
	return 0;
}
#include <iostream>
#include <vector>

using namespace std;

vector<int> score;
int num;

int main()
{
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		int t;
		cin >> t;
		score.push_back(t);
	}
	int max[300] = { 0, };		//i번째까지의 최대값
	//memset(max, 0, sizeof(max));
	//max[i]는 i번째를 밟았을때 최댓값
	max[0] = score[0];
	if (num == 1)
	{
		cout << max[num - 1] << endl;
		return 0;
	}
	max[1] = max[0] + score[1];
	if (num == 2)
	{
		cout << max[num - 1] << endl;
		return 0;
	}
	if (score[1] > score[0]) max[2] = score[1] + score[2];
	else max[2] = score[0] + score[2];
	for (int i = 3; i < num; i++)
	{
		int temp1 = score[i - 1] + max[i - 3];	//직전애 밟는경우
		int temp2 = max[i - 2];					//i-2번째 애 밟는경우
		if (temp1 > temp2)
		{
			max[i] = temp1 + score[i];
		}
		else
		{
			max[i] = temp2 + score[i];
		}
	}
	cout << max[num - 1] << endl;
	return 0;
}

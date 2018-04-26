#include <iostream>
#include <vector>

using namespace std;

vector<int> boxSize;

int main()
{
	int num;
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		int temp;
		cin >> temp;
		boxSize.push_back(temp);
	}
	int result[1000] = { 0, };
	result[0] = 1;
	if (boxSize[0] < boxSize[1]) result[1] = 2;
	else result[1] = 1;
	for (int i = 2; i < num; i++)
	{
		bool cont = false;
		for (int k = 1; (i - k) != -1; k++)
		{
			if (boxSize[i] > boxSize[i - k] && (result[i] - 1)<result[i - k])
			{
				result[i] = result[i - k] + 1;
				cont = true;
				//break;
			}
		}
		if (!cont) result[i] = 1;
	}
	int max = 0;
	for (int i = 0; i < num; i++)
	{
		if (max < result[i]) max = result[i];
	}
	cout << max << endl;
	return 0;
}
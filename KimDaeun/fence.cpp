#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<int> h;
int n;
int fence(int from, int to)
{
	if ((to - from) == 0) return h[from];
	int idxMdl = (to + from) / 2;
	int RectL = fence(from, idxMdl);
	int RectR = fence(idxMdl + 1, to);
	int result = max(RectL, RectR);
	result = max(result, 2 * min(h[idxMdl], h[idxMdl + 1])); //중간에 두개
	int left = idxMdl;
	int right = idxMdl + 1;
	int curH = min(h[idxMdl], h[idxMdl + 1]);
	while (1)
	{
		if ((left - 1) >= from && (right + 1) <= to)
		{
			if (h[left - 1] < h[right + 1])
			{
				right++;
				curH = min(curH, h[right]);
				result = max(result, (right - left + 1)*curH);
			}
			else
			{
				left--;
				curH = min(curH, h[left]);
				result = max(result, (right - left + 1)*curH);
			}
		}
		else if ((left - 1) < from && (right + 1) > to)//양쪽탐색끝나면
		{
			break;
		}
		else if ((left - 1) < from)	//왼쪽끝나면 오른쪽으로탐색
		{
			right++;
			curH = min(curH, h[right]);
			result = max(result, (right - left + 1)*curH);
		}
		else
		{
			left--;
			curH = min(curH, h[left]);
			result = max(result, (right - left + 1)*curH);
		}
	}
	return result;
}
int main()
{
	
	int c;
	cin >> c;
	for (int i = 0; i < c; i++)
	{
		
		cin >> n;

		for (int j = 0; j < n; j++)
		{
			int temp;
			cin >> temp;
			h.push_back(temp);
		}
		int result = fence(0,n-1);
		cout << result<<endl;
		h.clear();
	}
}
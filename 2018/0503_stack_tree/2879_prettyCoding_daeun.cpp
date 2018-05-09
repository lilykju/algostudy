#include <iostream>
#include <list>
#include <vector>

using namespace std;

vector<int> curTab;
vector<int> rightTab;
list<int> tapMgr;

int main()
{
	int num;
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		int t;
		cin >> t;
		curTab.push_back(t);
	}
	for (int i = 0; i < num; i++)
	{
		int t;
		cin >> t;
		rightTab.push_back(t);
	}
	//같은 type이면 push, 아니면 clear?
	int count = 0;
	//tapMgr.push_back(curTab[0]);
	int bound = rightTab[0]- curTab[0];
	int curIdx = 0;
	int searchIdx = 0;
	int beforeIdxType = rightTab[0] - curTab[0];
	while(1)
	{
		if (curIdx == num) break;
		if (searchIdx == num)
		{
			for (list<int>::iterator iter = tapMgr.begin(); iter != tapMgr.end(); ++iter)
			{
				curTab[*iter] += bound;
			}
			tapMgr.clear();
			//curIdx;
			searchIdx = curIdx;
			count += abs(bound);
			//if (curIdx == num) break;
			//tapMgr.push_back(curIdx);
			bound = rightTab[curIdx] - curTab[curIdx];
			while (bound == 0)
			{
				searchIdx++;
				curIdx++;
				if (curIdx == num) break;
				bound = rightTab[curIdx] - curTab[curIdx];
			}
			if (curIdx == num) break;
			beforeIdxType = rightTab[curIdx] - curTab[curIdx];
			continue;
		}
		int curIdxType = rightTab[searchIdx] - curTab[searchIdx];
		//고칠게 없으면
		/*if (curIdxType == 0)
		{
			curIdx++;
			searchIdx++;
			if (curIdx == num) break;
			beforeIdxType = rightTab[curIdx] - curTab[curIdx];
			bound = rightTab[curIdx] - curTab[curIdx];

			continue;
		}*/
		//same type
		if (curIdxType * beforeIdxType > 0)
		{
			//한번에 추가/삭제가능한 탭수
			if (abs(curIdxType) < abs(bound)) bound = curIdxType;
			tapMgr.push_back(searchIdx);
			searchIdx++;
		}
		else
		{
			for (list<int>::iterator iter = tapMgr.begin(); iter!=tapMgr.end(); ++iter)
			{
				curTab[*iter] += bound;
			}
			tapMgr.clear();
			//curIdx;
			searchIdx = curIdx;
			count+=abs(bound);
			//if (curIdx == num) break;
			//tapMgr.push_back(curIdx);
			bound = rightTab[curIdx] - curTab[curIdx];
			while (bound == 0)
			{
				searchIdx++;
				curIdx++;
				if (curIdx == num) break;
				bound = rightTab[curIdx] - curTab[curIdx];
			}
			if (curIdx == num) break;
			beforeIdxType = rightTab[curIdx] - curTab[curIdx];
			//bound = rightTab[curIdx] - curTab[curIdx];
		}
	}
	cout << count << endl;

	return 0;
}
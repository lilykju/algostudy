// CutTheTree.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int cutTheTree1(vector <int> data, vector < vector<int> > edges) {
	// Complete this function
	//map <int, int> mapData;
	vector<int> sum;
	sum.assign(edges.size() + 1, -1);

	int total = 0;

	//edges의 0번째, 1번째 값과 data의 value를 연결
	/*mapData[1] = data[0];
	int count = 1;
	for (int i = 0; i < edges.size(); i++)
	{
	if (mapData.find(edges[i][0]) == mapData.end())
	{
	mapData[edges[i][0]] = data[count++];
	if (mapData.find(edges[i][1]) == mapData.end())
	{
	mapData[edges[i][1]] = data[count++];
	}
	}
	else
	{
	mapData[edges[i][1]] = data[count++];
	}
	total += mapData[i];
	}*/

	for (int i = edges.size() - 1; i >= 0; i--)
	{
		if (sum[edges[i][0] - 1] == -1)	//리프노드는 -1로 정의 되도록
		{
			sum[edges[i][0] - 1] = 0;
		}
		sum[edges[i][0] - 1] += data[edges[i][1] - 1];
	}

	int diff = 100000000000000000;
	for (int i = 0; i < sum.size(); i++)
	{
		if (sum[i] != -1)
		{
			int temp = 0;
			if (sum[i] < total - sum[i])
			{
				temp = total - 2 * sum[i];
			}
			else
			{
				temp = 2 * sum[i] - total;
			}
			if (diff > temp)
			{
				diff = temp;
			}
		}
	}
	return diff;
}

int main() {
	int n;
	cin >> n;
	vector<int> data(n);
	for (int data_i = 0; data_i < n; data_i++) {
		cin >> data[data_i];
	}
	vector< vector<int> > edges(n - 1, vector<int>(2));
	for (int edges_i = 0; edges_i < n - 1; edges_i++) {
		for (int edges_j = 0; edges_j < 2; edges_j++) {
			cin >> edges[edges_i][edges_j];
		}
	}
	int result = cutTheTree1(data, edges);
	cout << result << endl;
	return 0;
}
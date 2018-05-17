#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int INT_MAXX = numeric_limits<int>::max();
const int INT_MINN = numeric_limits<int>::min();

struct RMQ
{
	int n;
	vector<int> rangeMin;
	RMQ(const vector<int>& array)
	{
		n = array.size();
		rangeMin.resize(n * 4);	//배열의 길이 쉽게구하기
		init(array, 0, n - 1, 1);
	}
	int init(const vector<int>& array, int left, int right, int node)
	{
		if (left == right) return rangeMin[node] = array[left];
		int mid = (left + right) / 2;
		int leftMin = init(array, left, mid, node * 2);
		int rightMin = init(array, mid + 1, right, node * 2 + 1);
		return rangeMin[node] = min(leftMin, rightMin);
	}
	int query(int left, int right, int node, int nodeLeft, int nodeRight)
	{
		if (right < nodeLeft || nodeRight < left) return INT_MAXX;
		if (left <= nodeLeft && nodeRight <= right) return rangeMin[node];
		int mid = (nodeLeft + nodeRight) / 2;
		return min(query(left, right, node * 2, nodeLeft, mid),
			query(left, right, node * 2 + 1, mid + 1, nodeRight));
	}
	int query(int left, int right) {
		return query(left, right, 1, 0, n - 1);
	}
	int update(int index, int newValue, int node, int nodeLeft, int nodeRight)
	{
		if (index < nodeLeft || nodeRight < index) return rangeMin[node];
		if (nodeLeft == nodeRight) return rangeMin[node] = newValue;
		int mid = (nodeLeft + nodeRight) / 2;
		return rangeMin[node] = min(update(index, newValue, node * 2, nodeLeft, mid),
			update(index, newValue, node * 2 + 1, mid + 1, nodeRight));
	}
	int update(int index, int newValue)
	{
		return update(index, newValue, 1, 0, n - 1);
	}
};

struct RXQ
{
	int n;
	vector<int> rangeMax;
	RXQ(const vector<int>& array)
	{
		n = array.size();
		rangeMax.resize(n * 4);	//배열의 길이 쉽게구하기
		init(array, 0, n - 1, 1);
	}
	int init(const vector<int>& array, int left, int right, int node)
	{
		if (left == right) return rangeMax[node] = array[left];
		int mid = (left + right) / 2;
		int leftMin = init(array, left, mid, node * 2);
		int rightMin = init(array, mid + 1, right, node * 2 + 1);
		return rangeMax[node] = max(leftMin, rightMin);
	}
	int query(int left, int right, int node, int nodeLeft, int nodeRight)
	{
		if (right < nodeLeft || nodeRight < left) return INT_MINN;
		if (left <= nodeLeft && nodeRight <= right) return rangeMax[node];
		int mid = (nodeLeft + nodeRight) / 2;
		return max(query(left, right, node * 2, nodeLeft, mid),
			query(left, right, node * 2 + 1, mid + 1, nodeRight));
	}
	int query(int left, int right) {
		return query(left, right, 1, 0, n - 1);
	}
	int update(int index, int newValue, int node, int nodeLeft, int nodeRight)
	{
		if (index < nodeLeft || nodeRight < index) return rangeMax[node];
		if (nodeLeft == nodeRight) return rangeMax[node] = newValue;
		int mid = (nodeLeft + nodeRight) / 2;
		return rangeMax[node] = max(update(index, newValue, node * 2, nodeLeft, mid),
			update(index, newValue, node * 2 + 1, mid + 1, nodeRight));
	}
	int update(int index, int newValue)
	{
		return update(index, newValue, 1, 0, n - 1);
	}
};
int main()
{
	int c, n, q = 0;
	int a, b = 0;
	
	cin >> c;
	while(c--)
	{
		cin >> n >> q;
		vector<int> h(n);
		for (int i = 0; i < n; i++)
		{
			cin >> h[i];
		}
		struct RMQ seg_min(h);
		struct RXQ seg_max(h);

		for (int i = 0; i < q; i++)
		{
			cin >> a >> b;
			cout << seg_max.query(a, b)-seg_min.query(a, b) << endl;
		}
	}
	return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int INT_MAXX = numeric_limits<int>::max();

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
};

const int MAX_N = 200000;
int n;
vector<int> child[MAX_N];
int no2serial[MAX_N], serial2no[MAX_N];
int locInTrip[MAX_N], depth[MAX_N];
int nextSerial;

void traverse(int here, int d, vector<int>& trip)
{
	no2serial[here] = nextSerial;
	serial2no[nextSerial] = here;
	++nextSerial;
	depth[here] = d;
	locInTrip[here] = trip.size();
	trip.push_back(no2serial[here]);
	for (int i = 0; i < child[here].size(); ++i)
	{
		traverse(child[here][i], d + 1, trip);
		trip.push_back(no2serial[here]);
	}
}
RMQ* prepareRMQ()
{
	nextSerial = 0;
	vector<int> trip;
	traverse(0, 0, trip);
	return new RMQ(trip);
}
int distance(RMQ* rmq, int u, int v)
{
	int lu = locInTrip[u], lv = locInTrip[v];
	if (lu > lv) swap(lu, lv);
	int lca = serial2no[rmq->query(lu, lv)];
	return depth[u] + depth[v] - 2 * depth[lca];
}
int main()
{
	int c = 0, n = 0, q = 0, p = 0;
	int a = 0, b = 0;
	scanf("%d", &c);
	//cin >> c;
	while (c--)
	{
		scanf("%d %d", &n, &q);
		//cin >> n >> q;
		for (int i = 1; i < n; i++)
		{
			scanf("%d", &p);
			//cin >> p;
			child[p].push_back(i);
		}
		struct RMQ* seg = prepareRMQ();

		for (int i = 0; i < q; i++)
		{
			scanf("%d %d", &a, &b);
			//cin >> a >> b;
			printf("%d\n", distance(seg, a, b));
		}
	}
	return 0;
}
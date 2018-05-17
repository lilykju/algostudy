#include <iostream>
#include <vector>

using namespace std;

vector<int> arr;

struct FenwickTree
{
	vector<long long> tree;
	FenwickTree(int n) : tree(n + 1) {}
	long long sum(int pos)
	{
		long long ret = 0;
		while (pos > 0)
		{
			ret += tree[pos];
			pos &= (pos - 1);
		}
		return ret;
	}
	void add(int pos, int val)
	{
		while (pos < tree.size())
		{
			tree[pos] += val;
			pos += (pos&-pos);
		}
	}
	void change(int pos, int val)
	{
		//더해줄 값
		val = val - arr[pos-1];
		while (pos < tree.size())
		{
			tree[pos] += val;
			pos += (pos&-pos);
		}
	}
};

int main()
{
	int n, m, k, num;
	int temp = 1;
	cin >> n >> m >> k;
	FenwickTree fTree(n);
	while (n--)
	{
		cin >> num;
		arr.push_back(num);
		fTree.add(temp++, num);
	}
	int a, b, c;
	while (m > 0 || k > 0)
	{
		cin >> a >> b >> c;
		//update
		if (a == 1)
		{
			m--;
			fTree.change(b, c);
		}
		//calculate
		else
		{
			k--;
			long long cSum = fTree.sum(c);
			long long bSum = fTree.sum(b - 1);
			cout << cSum - bSum << endl;
		}
	}
	return 0;
}
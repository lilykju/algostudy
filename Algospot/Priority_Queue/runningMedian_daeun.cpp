#include <iostream>
#include <queue>
#include <vector>
#include <functional>
using namespace std;

struct RNG
{
	int seed, a, b;
	RNG(int _a, int _b) : a(_a), b(_b), seed(1983) {}
	int next()
	{
		int ret = seed;
		seed = ((seed*(long long)a) + b) % 20090711;
		return ret;
	}
};

int runningMedian(int n, RNG rng)
{
	priority_queue<int, vector<int>, less<int>> frontH;
	priority_queue<int, vector<int>, greater<int>> endH;
	int ret = 0;
	for (int cnt = 1; cnt <= n; ++cnt)
	{
		//front heap과 end heap의 크기를 동일하게 유지! front 힙이 1 크거나 같게
		if (frontH.size() == endH.size()) frontH.push(rng.next());
		else endH.push(rng.next());
		//end heap의 top이 front heap의 top보다 크면 둘의 원소를 교환한다.
		if (!endH.empty() && !frontH.empty() && endH.top() < frontH.top())
		{
			//swap(frontH.top(), endH.top());
			int a = frontH.top();
			int b = endH.top();
			frontH.pop();
			endH.pop();
			frontH.push(b);
			endH.push(a);
		}
		ret = (ret + frontH.top()) % 20090711;
	}
	return ret;
}

int main()
{
	int c, n, a, b = 0;
	cin >> c;
	for (int i = 0; i < c; i++)
	{
		cin >> n >> a >> b;
		RNG rng_input(a, b);
		cout << runningMedian(n, rng_input) << endl;
	}
	return 0;
}

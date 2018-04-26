#include <iostream>
#include <cstring>

unsigned int cache[100];
int tiling(int n)
{
	if (n <= 1) return 1;
	if (n == 2) return 2;
	if (cache[n - 2] == -1)
	{
		cache[n - 2] = tiling(n - 1) % 1000000007;
	}
	if (cache[n - 3] == -1)
	{
		cache[n - 3] = tiling(n - 2) % 1000000007;
	}
	cache[n - 1] = (cache[n - 2] + cache[n - 3]) % 1000000007;
	return cache[n - 1];
}

int main()
{
	int test = 0;
	std::cin >> test;
	int n = 0;
	for (int i = 0; i < test; i++)
	{
		memset(cache, -1, sizeof(cache));
		n = 0;
		std::cin >> n;
		std::cout << tiling(n) << std::endl;
	}
	return 0;
}
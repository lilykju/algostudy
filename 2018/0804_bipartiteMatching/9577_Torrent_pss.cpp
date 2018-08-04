#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <stack>
#include <queue>
#include <cstring>
using namespace std;

int n, m;
int adj[200][200];
int arr1[200], arr2[200];
bool visited[200];
bool dfs(int x) {
	visited[x] = true;
	for (int i = 1; i <= n; ++i) {
		if (arr2[adj[x][i]] == -1 || !visited[arr2[adj[x][i]]] && dfs(arr2[adj[x][i]]))
		{
			arr1[x] = adj[x][i];
			arr2[adj[x][i]] = x;
			return true;
		}
	}
	return false;
}

int main(void) {
	int t;
	cin >> t;
	while (t--) {
		cin >> n >> m;
		for (int i = 0; i < m; ++i) {
			int t1, t2, num;
			cin >> t1 >> t2 >> num;
			for (int j = 0; j < num; ++j) {
				int temp;
				cin >> temp;
				for (int k = t1 + 1; k <= t2; ++k) {
					adj[k][temp] = 1;
				}
			}
			int size = 0;
			memset(arr1, -1, sizeof(arr1));
			memset(arr2, -1, sizeof(arr2));
			for (int j = 0; j < 102; ++j) {
				memset(visited, false, sizeof(visited));
				if (dfs(j)) {
					size++;
					if (size == n) {
						cout << j;
						break;
					}
				}
				if (j == 101) {
					cout << -1;
				}
			}
		}
	}
	return 0;
}
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

typedef long long ll;

int N, M;
ll a[200011];
ll x;

int main() {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		cin >> a[i];
		
	}
	ll cnt = 0;
	ll index = 0;
	for (int i = 1; i <= M; i++) {
		cin >> x;

		while (cnt<x) {
			index++;
			cnt += a[index];
		}
		cout << index << " " << x - (cnt - a[index]) << "\n";
	}
}

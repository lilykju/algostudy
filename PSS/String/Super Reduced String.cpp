#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <stack>

using namespace std;

int main(void)
{
	string ln;
	cin >> ln;
	int len = ln.size();
	stack<char> lefts, rights;
	for (int i = 0; i < len; ++i) {
		lefts.push(ln[i]);
	}
	while (!lefts.empty()) {
		char left, right;
		left = lefts.top();
		if (!rights.empty()) {
			right = rights.top();
			//cout << left << ' ' << right << endl;
			if (left == right) {
				lefts.pop();
				rights.pop();
			}
			else {
				rights.push(left);
				lefts.pop();
			}
		}
		else {
			rights.push(left);
			lefts.pop();
		}
		
	}
	if (rights.empty())
	{
		cout << "Empty String";
		return 0;
	}
	while (!rights.empty()) {
		cout << rights.top();
		rights.pop();
	}
	return 0;
}
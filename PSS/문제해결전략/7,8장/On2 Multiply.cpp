#include <iostream>
#include <vector>

using namespace std;

class multiple_example {
public:
	multiple_example(void) {}

	
	
	//c store numbers inverse sequence
	//ex 12345 ==> c = { 5, 4, 3, 2, 1}
	void nomalize(vector<int>& c) {
		
		c.push_back(0); // ex c = {5,4,3,2,1,0}
		for (int i = 0; i < c.size(); ++i) {
			if (c[i] < 0) {
				int borrow = (abs(c[i]) + 9) / 10;
				c[i + 1] -= borrow;
				c[i] += borrow * 10;
			}
			else {
				c[i + 1] += (c[i] / 10);
				c[i] %= 10;
			}
		}
		while (c.size() > 1 && c.back() == 0)
			c.pop_back();
	}

	vector<int> multiply(const vector<int>& a, const vector<int>& b) {
		vector<int> c(a.size() + b.size() + 1, 0);
		for (int i = 0; i < a.size(); ++i) {
			for (int j = 0; j < b.size(); ++j) {
				c[i + j] += a[i] * b[j];
			}
		}
		print(c);
		nomalize(c);
		print(c);
		return c;
	}

	void print(vector<int>& c) {
		for (int i = c.size() - 1; i >= 0; --i) {
			cout << c[i] << ' ';
		}
		cout << endl;
	}
};

int main(void)
{
	vector<int> a;
	vector<int> b;
	for (int i = 0; i < 4; ++i) {
		int k;
		cin >> k;
		a.push_back(k);
	}
	for (int i = 0; i < 4; ++i) {
		int k;
		cin >> k;
		b.push_back(k);
	}
	
	multiple_example ex;
	ex.multiply(a, b);
	return 0;
}
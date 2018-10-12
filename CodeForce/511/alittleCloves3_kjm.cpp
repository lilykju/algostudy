#include <iostream>
using namespace std;

int main(void)
{
	int n;
	cin >> n;

	switch (n % 3)
	{

	case 1:
		cout << "1 1 " << n - 2 << endl; break;
	case 2:
		cout << "1 2 " << n - 3 << endl; break;
	default:
		cout << "1 1 " << n - 2 << endl;

	}
}
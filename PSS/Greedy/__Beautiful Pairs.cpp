#include <iostream>
#include <algorithm>

using namespace std;

int remove_dup(int *a,int sz) {
	int i, j=0, k;
	for (i = 0; i < sz; ++i) {
		for (k = 0; k < i; ++k) {
			if (a[k] == a[i])
				break;
		}
		if (!(k < i))
			a[j++] = a[i];
	}
	return j;
}
int main(void)
{
	int n;
	cin >> n;
	int a[2001];
	int b[2001];
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	for (int i = 0; i < n; ++i)
		cin >> b[i];
	
	sort(a, a + n);
	sort(b, b +n);

	for (int i = n - 1; i >= 0; --i)
	{
		if (a[i] != b[i])
		{
			b[i] = a[i];
			break;
		}
	}
	sort(b, b + n);
	int alen = remove_dup(a, n);
	int blen = remove_dup(b, n);

	
	cout << min(alen, blen)+1 << endl;

	
	
	return 0;
	
	

}
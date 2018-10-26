#include <stdio.h>

int test(int n) {

	int a, b, tmp = n;

	if (tmp < 100)
		return 1;
	else if (tmp == 1000)
		return 0;
	else
	{
		a = ((tmp / 10) % 10) - (tmp % 10);
		b = ((tmp / 100) % 10) - ((tmp / 10) % 10);
	}

	if (a == b)
		return 1;
	else return 0;

}

int main(void) {

	int N, count = 0, a;

	scanf("%d", &N);

	for (int i = 1; i <= N; i++)
	{
		a = test(i);

		if (a)
			count++;
	}

	printf("%d", count);

}
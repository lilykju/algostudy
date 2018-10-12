#include <stdio.h>


int main(void)
{
	int T; //Test case
	scanf("%d", &T);
	int a, b; //(x,y)
	int sum = 0;
	int max = 0;

	while (T--) {

		scanf("%d %d", &a, &b);

		sum = a + b;
		if (sum > max) max = sum;
	}

	printf("%d", max);

}
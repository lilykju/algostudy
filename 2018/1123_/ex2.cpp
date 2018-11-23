#include <iostream>
#include <queue>
#include <tuple>
#include <windows.h>

#define size 6

using namespace std;

int x_color[1001] = { 0, };
int y_color[1001] = { 0, };
int z_color[1001] = { 0, };
int result_color[1001] = { 0, };
int result[1001] = { 0, };

void processing(istream& is, ostream& os) {
	//vector<tuple<int, int, int> > next;
	//vector<tuple<int, int, int> > temp;
	//tuple<int, int, int> ed;
	//tuple<int, int, int> range;
	//tuple<int, int, int> start;
	int start_x, start_y, start_z;
	int ed_x, ed_y, ed_z;
	int T, num_of_color, count=0;
	is >> T;

	is >> ed_x >> ed_y >> ed_z;
	is >> start_x >> start_y >> start_z;
	is >> num_of_color;
	
	for (int i = 0; i < ed_x; ++i) {
		int middle = abs((i - start_x)%num_of_color);
		x_color[middle]++;
	}

	for (int i = 0; i < ed_y; ++i) {
		int middle = abs((i - start_y) % num_of_color);
		y_color[middle]++;
	}

	for (int i = 0; i < ed_z; ++i) {
		int middle = abs((i - start_z) % num_of_color);
		z_color[middle]++;
	}

	for (int i = 0; i < num_of_color; ++i) {
		if (y_color[i] != 0) {
			for (int j = 0; j < num_of_color; ++j) {
				result_color[(j + i) % num_of_color] += y_color[i] * x_color[j];
			}
		}
	}

	for (int i = 0; i < num_of_color; ++i) {
		if (z_color[i] != 0) {
			for (int j = 0; j < num_of_color; ++j) {
				result[(j + i) % num_of_color] += z_color[i] * result_color[j];
			}
		}
	}


	for (int i = 0; i < num_of_color; ++i)
		os << result[i] << " ";
	os << endl;


	system("pause");
}

int main(void) {

	processing(cin, cout);

	return 0;
}
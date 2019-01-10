#include <iostream>
#include <vector>

using namespace std;

#define pii pair<int, int>

int L, R;
int add_row[4] = { 0, -1, 0, 1 };
int add_col[4] = { 1, 0, -1, 0 };

void initialize(istream& is, int(*datas)[52], int N) {
	int data;
	for (int i = 1; i <= N; ++i)
		for (int j = 1; j <= N; ++j) {
			cin >> data;
			datas[i][j] = data;
		}
}

void print(const int(*datas)[52], int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j)
			cout << datas[i][j] << " ";
		cout << endl;
	}
}

bool check_range(int(*range)[52], int(*datas)[52], vector <pii >& element, int N) {
	int check = false;
	int row, col;

	for (row = 1; row <= N; ++row) {
		for (col = 1; col <= N; ++col) {

			for (int i = 0; i < 4; ++i) {
				int new_row = row + add_row[i];
				int new_col = col + add_col[i];

				if (range[row][col] == 0 && range[new_row][new_col] == 0 && 1 <= new_row && new_row <= N && 1 <= new_col && new_col <= N) {

					int value = abs(datas[new_row][new_col] - datas[row][col]);

					//cout << value << endl;
					if (L <= value && value <= R) {
						element.push_back(pii(row, col));

					}
					if (!element.empty()) {
						check = true;
						return check;
					}
				}
			}

		}
	}
	return check;
}

void duplicate(vector<pii >& temp, int new_row, int new_col)
{
	int i;
	pii temp2(new_row, new_col);

	for (i = 0; i < temp.size() && !(temp[i] == temp2); ++i)
		;

	if (!(i < temp.size())) {
		//cout << new_row << " " << new_col << endl;
		temp.push_back(temp2);
	}
}

void move_range(int(*range)[52], int(*datas)[52], vector <pii >& element, int N)
{
	vector<pii > temp;

	while (!element.empty()) {
		while (!element.empty()) {
			//cout << "here" << endl;
			int row = element.back().first;
			int col = element.back().second;
			range[row][col] = 1;
			element.pop_back();

			for (int i = 0; i < 4; ++i) {
				int new_row = row + add_row[i];
				int new_col = col + add_col[i];

				if (range[row][col] == 1 && range[new_row][new_col] == 0 && 1 <= new_row && new_row <= N && 1 <= new_col && new_col <= N) {

					int value = abs(datas[new_row][new_col] - datas[row][col]);
					//cout << value << endl;
					if (L <= value && value <= R) {
						duplicate(temp, new_row, new_col);
					}
				}
			}

		}
		while (!temp.empty()) {
			element.push_back(temp.back());
			temp.pop_back();
		}
	}
}

void moving(int(*range)[52], int(*datas)[52], int N) {
	int avg, num, sum = 0;

	vector<pii > cal;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (range[i][j] == 1) {
				range[i][j] = -1;

				sum += datas[i][j];
				cal.push_back(pii(i, j));
			}
		}
	}

	if (cal.size() > 0) {
		num = cal.size();
		avg = sum / num;

		int row, col;
		while (!cal.empty()) {
			row = cal.back().first;
			col = cal.back().second;
			cal.pop_back();

			datas[row][col] = avg;
		}
	}
}

void range_ini(int(*range)[52], int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			range[i][j] = 0;
		}
	}
}

int moving(int(*datas)[52], int N) {
	vector<pii > element;
	int result = 0;

	bool key = true;
	//    while(check_range(range, datas, element, N)){
	//        move_range(range, datas, element, N);
	//
	//    }

	while (key) {
		int cnt = 0;
		int range[52][52] = { 0, };
		while (check_range(range, datas, element, N)) {
			move_range(range, datas, element, N);
			moving(range, datas, N);
			//print(datas, N);
			cnt++;
		}
		result++;

		if (cnt == 0) {
			key = false;
		}
	}

	//    print(range, N);

	return result - 1;
}

void processing(istream& is, ostream& os) {
	int datas[52][52] = { 0, };
	int N, result;
	is >> N >> L >> R;


	initialize(is, datas, N);
	if (N == 1)
		result = 0;
	else
		result = moving(datas, N);


	os << result << endl;
}


int main(void) {
	processing(cin, cout);


	return 0;
}


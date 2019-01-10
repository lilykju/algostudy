//#include <Windows.h>
#include <string>
#include <iostream>
#include <vector>
#include <queue>

#define pii pair<int, int>

using namespace std;

char datas[302][302] = { "0", };
int add_row[8] = {0, -1, -1, -1, 0, 1, 1, 1};
int add_col[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int result = 0;


void print(int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			cout << datas[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

void initialize(istream& is, int N) {
	char data;
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j){
			is >> data;
			datas[i][j] = data;
		}
	}
}

void duplicate_remove(int row, int col, vector<pii>& temp) {
	pii p(row, col);
	int i;
	for (i = 0; i < temp.size() && !(temp[i] == p); ++i)
		;
	if (i == temp.size()) {
		temp.push_back(pii(p));
	}
}

void BFS(int row, int col, int N) {
	vector<pii> v, temp;
	v.push_back(pii(row, col));

	

	while (!v.empty()) {
		while (!v.empty()) {
			int row = v.back().first;
			int	col = v.back().second;
			v.pop_back();
			datas[row][col] = 0;
			

			
			for (int k = 0; k < 8; ++k) {
			
				int new_row = row + add_row[k];
				int	new_col = col + add_col[k];
				int mine = 0;
				
				if (datas[new_row][new_col] == '.') {
					for (int l = 0; l < 8; ++l) {
						int s_new_row = new_row + add_row[l];
						int	s_new_col = new_col + add_col[l];

						if (1 <= s_new_row && s_new_row <= N && 1 <= s_new_col && s_new_col <= N && datas[s_new_row][s_new_col] == '*') {
							++mine;
						}
					}
					if (mine == 0) {
						duplicate_remove(new_row, new_col, temp);
						
						//cout << new_row << " " << new_col << endl;
					}
					else {
						datas[new_row][new_col] = mine;
					}
				}
			}
		}
		while (!temp.empty()) {
			v.push_back(temp.back());
			temp.pop_back();
		}
	}
	
	++result;

	//print(N);
}

void datas_search(int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (datas[i][j] == '.') {
				int row = i, col = j, mine = 0;

				for (int k = 0; k < 8; ++k) {
					int new_row = row + add_row[k];
					int new_col = col + add_col[k];

					if (1 <= new_row && new_row <= N && 1 <= new_col && new_col <= N && datas[new_row][new_col] == '*') {
						++mine;
					}
				}
				if (mine == 0) {
					BFS(row, col, N);
					datas[row][col] = '*';
				}
			}
		}
	}
}

void post_process(int N) {
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= N; ++j) {
			if (datas[i][j] == '.') {
				++result;
			}
		}
	}
}

void processing(istream& is, ostream& os, int i) {
	int N;
	is >> N;

	initialize(is, N);
	datas_search(N);
	post_process(N);
	
	
	//print(N); // for debugging
	os << "#"<<i<<" "<< result << endl;
}

int main(void) {

	int T;
	cin >> T;
	for(int i=1; i<=T; ++i){
		result = 0;
		processing(cin, cout, i);
		
	}
	//system("pause");

	return 0;
}
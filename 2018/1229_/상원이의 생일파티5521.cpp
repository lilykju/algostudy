#include <Windows.h>
#include <iostream>
#include <vector>
#include <string>
#include <list>

#define INVITOR relate[1].close
#define INVITED relate[INVITOR[i]].close

using namespace std;

struct part {
	vector<int> close;
};

void initialize(int N, int M, istream& is, vector<part>& relate);

//void compare(int i, vector<bird>& order, list<bird> align);


void processing(int T, istream& is, ostream& os) {
	int result[501] = { 0, };

	vector<part> relate;

	int N, M, count=0;
	is >> N >> M;

	initialize(N, M, is, relate);

	for (int i = 0; i < INVITOR.size(); ++i) {
		result[INVITOR[i]] = 1;
		for (int j = 0; j < INVITED.size(); ++j) {
			if(INVITED[j]!=1)
				result[INVITED[j]] = 1;
		}
	}

	
	for (int i = 0; i < 501; ++i)
		if (result[i] == 1)
			count++;

	//compare(N, order, align);

	cout << "#" << T << " "<<count << endl;
		
}

int main() {

	int T;
	cin >> T;

	for (int i = 1; i <= T; ++i)
		processing(i, cin, cout);


	system("pause");

	return 0;
}

void initialize(int N, int M, istream& is, vector<part>& relate) {
	for (int i = 0; i <=N; ++i) {
		part data;
		relate.push_back(data);
	}

	for (int i = 0; i < M; ++i) {
		int f1, f2;
		is >> f1 >> f2;
		relate[f1].close.push_back(f2);
		relate[f2].close.push_back(f1);
	}
}



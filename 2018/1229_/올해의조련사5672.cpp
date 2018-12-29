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
			if(INVITED[i]!=1)
				result[INVITED[i]] = 1;
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

//void compare(int N, vector<bird>& order, list<bird> align) {
//
//	while (!align.empty()) {
//		int sz = align.size();
//		int middle;
//		list<bird>::iterator it;
//		it = align.begin();
//
//		if (align.size() == 1) {
//			order.push_back(align.back());
//			align.pop_back();
//
//		}
//		else if (align.front().name < align.back().name) {
//			order.push_back(align.front());
//			align.pop_front();
//
//		}
//		else if (align.front().name > align.back().name) {
//			order.push_back(align.back());
//			align.pop_back();
//		}
//		else {
//			list<bird>::iterator it1, it2;
//			it1 = align.begin();
//			it2 = align.end();
//			it2--;
//
//			if (sz % 2 == 0) {
//				middle = sz / 2 - 1;
//			}
//			else {
//				middle = sz / 2;
//			}
//			int count = 0;
//			while (((*it1).name == (*it2).name) && count != middle) {
//				it1++;
//				it2--;
//				count++;
//			}
//
//			if (count == middle) {
//				order.push_back(align.back());
//				align.pop_back();
//			}
//			else {
//				if ((*it1).name < (*it2).name) {
//					order.push_back(align.front());
//					align.pop_front();
//				}
//				else {
//					order.push_back(align.back());
//					align.pop_back();
//				}
//			}
//
//
//		}
//	}
//
//}

/*list<bird>::iterator it;

for (int i = 0; i< order.size(); ++i)
	cout << order[i].name << endl;*/


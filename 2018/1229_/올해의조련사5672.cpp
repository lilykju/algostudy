//#include <Windows.h>
#include <iostream>
#include <vector>
#include <string>
#include <list>

using namespace std;

struct bird {
	string name;
	bird *nextptr;
};

void initialize(int N, istream& is, list<bird>& align);
void compare(int i, vector<bird>& order, list<bird> align);


void processing(int T, istream& is, ostream& os) {
	
	vector<bird> order;
	list<bird> align;
	int N;
	is >> N;

	initialize(N, is, align);
	compare(N, order, align);

	cout << "#" << T << " ";

	for (int i = 0; i < order.size(); ++i)
		os << order[i].name;
	
	os << endl;
}

int main() {

	int T;
	cin >> T;

	for (int i = 1; i <= T; ++i)
		processing(i,cin, cout);
	
	
	//system("pause");

	return 0;
}

void initialize(int N, istream& is, list<bird>& align) {
	for (int i = 0; i < N; ++i) {
		bird data;
		is >> data.name;
		align.push_back(data);
	}
}

void compare(int N, vector<bird>& order, list<bird> align) {
	
	while (!align.empty()) {
		int sz = align.size();
		int middle;
		list<bird>::iterator it;
		it = align.begin();

		if (align.size() == 1) {
			order.push_back(align.back());
			align.pop_back();

		}
		else if (align.front().name < align.back().name) {
			order.push_back(align.front());
			align.pop_front();

		}
		else if (align.front().name > align.back().name) {
			order.push_back(align.back());
			align.pop_back();
		}
		else {
			list<bird>::iterator it1, it2;
			it1 = align.begin();
			it2 = align.end();
			it2--;
			if (sz % 2 == 0) {
				middle = sz / 2 - 1;
			}
			else {
				middle = sz / 2;
			}
			int count = 0;
			while (((*it1).name == (*it2).name )&& count!=middle) {
				it1++;
				it2--;
				count++;
			}

			if (count == middle) {
				order.push_back(align.back());
				align.pop_back();
			}
			else {
				if ((*it1).name < (*it2).name) {
					order.push_back(align.front());
					align.pop_front();
				}
				else {
					order.push_back(align.back());
					align.pop_back();
				}
			}


		}
	}
	
}


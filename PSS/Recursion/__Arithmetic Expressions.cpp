#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class date {
	int d, m, y;
public:
	date(const int dd,const int mm,const int yy):d(dd),m(mm),y(yy){}
	date(string& str) {
		istringstream iss(str);
		iss >> d;
		iss >> m;
		iss >> y;
	}
	operator string() const {
		ostringstream oss;
		oss << d << '-';
		oss << m << '-';
		oss << y << endl;
		return oss.str();
	}
};

int main(void)
{
	string ln;
	date dt(1,1,1);

	while (getline(cin, ln) && ln != "quit") {
		dt = date(ln);
		cout << string(dt) << endl;
	}
}

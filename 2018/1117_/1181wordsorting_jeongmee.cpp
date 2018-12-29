#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

bool cmp(const string &a, const string &b)
{
    if (a.length() == b.length())
        return a < b;
        
    return a.length() < b.length();
}

int main(int argc, char** argv) {
	
	int T; // Testcase
	cin >> T;
	string w[20000];
	
	for(int i = 0; i<T; i++){
		cin >> w[i];
	}
	
	sort(w, w+T, cmp);
	
	for (int i = 0; i < T; i++){
   		if (w[i] != w[i + 1])
            cout << w[i]<<'\n';
	}     
	
	return 0;
}

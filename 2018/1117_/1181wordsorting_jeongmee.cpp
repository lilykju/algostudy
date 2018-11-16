#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv) {
	
	int T;
	cin >> T;
	
	for(int testcase = 1; testcase<=T; testcase++){
		
		int num = 0;
		
		int n, m; // n = number of vertex, m = number of edge
		cin >> n >> m;
		
		vector<int> v[50];
		
		while(m--){
			
			int x, y;
			cin >> x >> y;
			
			v[x].push_back(y);
		}
		
	}
	
}

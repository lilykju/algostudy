#include <iostream>

using namespace std;

int main(int argc, char** argv) {
	
	int T;
	cin >> T;
	
	for(int testcase = 1; testcase<=T; testcase++){
		
		int n, m;
		cin >> n >> m;
		
		int ans = 0;
		
		int a[51][51] = {0, };
		
		for(int i = 0; i < m; i++){
			int x, y;
			cin >> x >> y;
			
			a[x][y] = 1;
			a[y][x] = 1;
		}
		
		for(int i = 1; i <= n; i++){
			for(int j = i+1; j <= n; j++){
				if(a[i][j] == 1){
					for(int k = j+1; k <= n; k++){
						if(a[j][k] == 1 && a[k][i] == 1)
							ans ++;
					}
				}
			}
		}
		
		cout << "#" << testcase << " " << ans << endl;
	}
}

#include <iostream>
#include <algorithm>

using namespace std;

int n, result = 0;
char m[300][300];
int c[300][300];
int v[300][300] = {0, };

void cSet(){
	
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
				
			if(m[i][j] == '*'){
					
				for(int k = i-1; k <= i+1; k++)
					for(int l = j-1; l <= j+1; l++){
							
						if (m[k][l] != '*' && 0 <= k && k <= n-1 && 0 <= l &&  l <= n-1)
							c[k][l]++;
						}
			}
		}
	}
	
	return;
}

void find(int i, int j){ // 0 주변을 다 1로 만든다. 
	
	for(int k = i-1; k <= i+1; k++)
		for(int l = j-1; l <= j+1; l++){
			if (v[k][l] == 0 && 0 <= k && k <= n-1 && 0 <= l &&  l <= n-1){
				v[k][l] = 1;
				
				if(c[k][l] == 0)
					find(k, l);
			}
		}
	
	return;
}

void leftCount(){
	
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
				
			if(v[i][j] == 0)
				result++;
		}
	}
	
	return;
}

int main(){
	
	int T;
	cin >> T;
	
	for(int testcase = 1; testcase <= T; testcase++){
	
		cin >> n;
		
		result = 0;
		
		//* = 지뢰, . = 지뢰 없음.
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
				cin >> m[i][j];
				v[i][j] = 0;
				
				if(m[i][j] == '*'){
					c[i][j] = '*';
					v[i][j] = 1;
				}
			}
		}
		
		cSet();
		
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
				if(c[i][j] == 0 && v[i][j] == 0){
				
					v[i][j] = 1;
				
					find(i, j);
					
					result++;
				}
			}
		}
		
		leftCount();
				
		cout << '#' << testcase << ' ' << result << endl;
		
	}
	
	return 0;
}

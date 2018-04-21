#include <iostream>

using namespace std;

int prime[9] = {2,3,5,7,11,13,17,19,23};
double a_pro, b_pro;
double cache2[20][20][20]; // max = 18

bool scoreprime(int n){
	for(int i=0;i<9;++i){
		if(prime[i] == n){
			return true;
		}
	}
	return false;
}

double go(int m,int a_score,int b_score){

	if(m == 18 && (scoreprime(a_score) || scoreprime(b_score)) ){
		return 1.0;
	}
	else if(m == 18) {
		return 0.0;
	}

	double& ret = cache2[m][a_score][b_score];
	if(ret != -1.0){
		return ret;
	}
	ret = 0;
	
	ret += (a_pro * (1.0 - b_pro)) * go(m+1,a_score+1,b_score); 
	ret += ((1.0 - a_pro) * b_pro) * go(m+1,a_score,b_score+1) ;
	ret += (a_pro * b_pro) * go(m+1,a_score + 1,b_score + 1) ;
	ret += ((1.0 - a_pro) * (1.0 - b_pro)) * go(m+1,a_score,b_score);
	return ret;

	/*???
	return ret = (a_pro * (1.0 - b_pro)) * go(m+1,a_score+1,b_score) 
	 + ((1.0 - a_pro) * b_pro) * go(m+1,a_score,b_score+1) 
	 + (a_pro * b_pro) * go(m+1,a_score + 1,b_score + 1) 
	 + ((1.0 - a_pro) * (1.0 - b_pro)) * go(m+1,a_score,b_score);
	 이렇게 하면 틀렸다 .왜그럴까. 
	 */

}

int main(void){
	for(int i=0;i<20;++i){
		for(int j=0;j<20;++j){
			for(int k=0;k<20;++k){
				cache2[k][i][j] = -1.0;
			}
		}
	}
	
	int temp;
	cin >> temp;
	a_pro = temp*0.01;
	cin >> temp;
	b_pro = temp*0.01;
	cout.precision(9);
	cout << fixed;
	cout << go(0,0,0) << '\n';
	// for(int i=0;i<20;++i){
	// 	for(int j=0;j<20;++j){
	// 		for(int k=0;k<20;++k){
	// 		cout << cache2[k][i][j] << ' ';
	// 	}
	// 	}
	// 	cout << '\n';
	// }
	return 0;
}
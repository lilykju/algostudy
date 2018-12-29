#include <iostream>

using namespace std;
 
int n, pl, mi;
long int ans;
int x[20];
int y[20];
 
void findV(int now, long int sumX, long int sumY) {
    if(pl == (n/2) && mi == (n/2)) {
        long int temp;
        temp = sumX * sumX + sumY * sumY;
        
		if(ans > temp)   ans = temp;
        
		return ;
    }
 
    if(pl < n/2)   {
        pl++;
        findV(now + 1, sumX + x[now + 1], sumY + y[now + 1]);
        pl--;
    }
    
    if(mi < n/2)   {
        mi++;
        findV(now + 1, sumX - x[now + 1], sumY - y[now + 1]);
        mi--;
    }
    return ;
}
 
 
int main() {
	
    int T;
    cin >> T;
 
    for(int tc = 1; tc <= T; tc++) {
        
		cin >> n;
        
		for(int i = 0; i < n; i++)
		  cin >> x[i] >> y[i];
  
        pl = 1;
        mi = 0;
        ans = 99999999999;
 
        findV(0, x[0], y[0]);
        
        cout << "#" << tc << " " << ans << endl;
    }
    return 0;
}

#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
int N;
using namespace std;
string reverse(string A){
	char head=A[N];
	N++;
	if(head=='b' || head== 'w'){
		return string(1,head);
	}
	string ul=reverse(A);
	string ur=reverse(A);
	string ll=reverse(A);
	string lr=reverse(A);
	
	return string("x")+ll+lr+ul+ur;
}
int main()
{
	int T;
	cin>>T;
	while(T--){
		string a;
		cin>>a;
		N=0;
		cout<<reverse(a)<<endl;
	}
}


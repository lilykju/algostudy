#include<cstdio>
#include<vector>
#include<iostream>
#include<cmath>


using namespace std;

int main()
{
	vector<char> l;
	vector<char> r;
	string s;
	cin>>s;
	int len=s.size();
	for(int i=0;i<len;i++)
	{
		l.push_back(s[i]);
	}
	int n;
	cin>>n;
	while(n--)
	{
		char a;
		cin>>a;
		if(a=='L')
		{
			if(!l.empty())
			{
				r.push_back(l.back());
				l.pop_back();
			}
				
		}
		else if(a=='D')
		{
			if(!r.empty())
			{
				l.push_back(r.back());
				r.pop_back();
			}
		}
		else if(a=='B')
		{
			if(!l.empty())
				l.pop_back();
		}
		else if(a=='P')
		{
			char c;
			cin>>c;
			l.push_back(c);
		}
	
	}
    while(!l.empty()) {
        r.push_back(l.back());
        l.pop_back();
    }
    while(!r.empty()) {
        cout<<r.back();
        r.pop_back();
    }
	return 0;
}

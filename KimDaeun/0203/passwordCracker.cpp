// 180203_passwordCracker.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include <vector>
#include <iostream>
#include <string>

using namespace std;

vector<string> pass;
vector<string> answer;

bool recursion(string atp)
{
	if (atp.size() == 0)
	{
		return true;
	}
	for (int i = 0; i < pass.size(); i++)
	{
		string curStr = pass[i];
		if (atp.substr(0, curStr.size()) == curStr)
		{
			for (int j = 0; j < pass.size(); j++)
			{
				string sndStr = pass[j];
				if (atp.substr(curStr.size(), sndStr.size()) == sndStr)
				{
					answer.push_back(curStr);
					atp = atp.substr(curStr.size());
					recursion(atp);
					return true;
				}
			}
			
		}
	}
	return false;
}

string passwordCracker(string attempt) {
	// Complete this function
	recursion(attempt);
	for (int i = 0; i < answer.size(); i++)
	{
		cout << answer[i] << endl;
	}
}

int main() {
	int t;
	cin >> t;
	for (int a0 = 0; a0 < t; a0++) {
		int n;
		cin >> n;
		pass.clear();
		//vector<string> pass(n);
		for (int pass_i = 0; pass_i < n; pass_i++) {
			//cin >> pass[pass_i];
			string in;
			cin >> in;
			pass.push_back(in);
			cout << pass_i << endl;
		}
		string attempt;
		cin >> attempt;
		string result = passwordCracker(attempt);
		cout << result << endl;
	}
	return 0;
}
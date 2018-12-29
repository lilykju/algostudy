#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <deque>
#include <algorithm>
#include <fstream>
#include <string>
#include <cstring>
#include <map>
 
#define pii pair<int, int>
#define pli pair<long, int>
#define mii map<int, int>
#define msi map<string, int>
 
typedef unsigned long long ull;
typedef long long ll;
 
using namespace std;
 
 
 
#define GO
#define DEBUG
 
 
/*
 
5 21
-3 2 -4 -1 -5
 
*/
 
char arr[2001];
int L;
int R;
vector<char> ans;
 
//true => L제거 false => R제거
int offset;
bool findLorR(void) {
    char mychar = arr[L];
 
    if (L + offset >= R) {
        return true;//아무거나 return해도 된다. 
    }
    while (1) {
        char dqf = arr[L + offset];
        char dqb = arr[R - offset];
        if (mychar > dqb || mychar < dqf) {
            return false;
        }
        else if (mychar < dqb || mychar > dqf) {
            return true;
        }
        else {
            offset++;
        }
    }
}
 
int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
 
 
    int t;
    cin >> t;
    int k = 1;
    while (t--) {
        ans.clear();
        memset(arr, 0, sizeof(arr));
        int n;
        cin >> n;
        char temp;
        for (int i = 0; i < n; ++i) {
            cin >> arr[i];
        }
        L = 0;
        R = n - 1;
        while (ans.size() != n) {
            char dqf = arr[L];
            char dqb = arr[R];
            if (dqf < dqb) {
                ans.push_back(dqf);
                L++;
            }
            else if (dqf > dqb) {
                ans.push_back(dqb);
                R--;
            }
            else {
                offset = 1;
                bool result = findLorR();
                if (result) {
                    ans.push_back(dqf);
                    L++;
                }
                else {
                    ans.push_back(dqf);
                    R--;
                }
            }
        }
        cout << '#' << k++ << ' ';
        int len = ans.size();
        for (int i = 0; i < len; ++i) {
            cout << ans[i];
        }
        cout << '\n';
    }
     
 
 
    return 0;
}
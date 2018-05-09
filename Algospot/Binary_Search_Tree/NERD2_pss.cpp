#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
map<int, int> coords;
bool isDominated(int x, int y) {
       //x보다 오른쪽에 있는 점 중 가장 왼쪽에 있는 점을 찾는다.
       map<int, int>::iterator it = coords.lower_bound(x);
       //그런 점이 없으면(x,y)는 지배당하지 않는다.
       if (it == coords.end()) return false;
       return y < it->second;
}
void removeDominated(int x, int y) {
       map<int, int>::iterator it = coords.lower_bound(x);
       if (it == coords.begin()) return;
       --it;
       //it는 (x,y)의 바로 왼쪽에 있는 점.
       while (true) {
               //(x,y) 바로 왼쪽에 오는 점을 찾는다.
               if (it->second > y) break;
               // 이전 점이 더 없으므로 it만 지우고 종료한다.
               if (it == coords.begin()) {
                      coords.erase(it);
                      break;
               }
               //이전 점으로 이터레이터를 하나 옮겨 놓고 it를 지운다.
               else {
                      map<int, int>::iterator jt = it;
                      --jt;
                      coords.erase(it);
                      it = jt;
               }
       }
}
//새 점 (x,y) 가 추가되었을 때 coords를 갱신하고,
//다른 점에 지배당하지 않는 점들의 개수를 반환한다.
int registered(int x, int y) {
       //(x,y)가 이미 지배당하는 경우에는 그냥 (x,y)를 버린다. 왜냐하면 y는 증가하므로
       if (isDominated(x, y)) return coords.size();
       // 기존에 있던 점 중 (x,y)에 지배당하는 점들을 지운다.
       removeDominated(x, y);
       coords[x] = y;
       return coords.size();
}
int main(void)
{
       ios_base::sync_with_stdio(false);
       cin.tie(0);
       int t;
       cin >> t;
       while (t--) {
               int n;
               cin >> n;
               int a, b;
               int cnt = 0;
               for (int i = 0; i < n; ++i) {
                      cin >> a >> b;
                      cnt += registered(a, b);
       
                      //cout << cnt << endl;
               }
               cout << cnt << '\n';
               coords.clear();
       }
       return 0;
}
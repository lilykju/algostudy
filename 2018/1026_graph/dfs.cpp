#include <iostream>
#include <deque>
#include <queue>
#include <stdlib.h>

using namespace std;

char datas[1002][1002]={0,};

void initialize(istream & is, int row, int col,  queue<pair<int, int> >& jihoon, queue<pair<int, int> >& fire)
{   /*
    for(int i=1; i<=row; ++i){
        for(int j=1; j<=col; ++j){
            is >> datas[i][j];
            if(datas[i][j]=='J')
                jihoon.push(pair<int, int>(i, j));
            else if(datas[i][j]=='F')
                fire.push(pair<int, int>(i, j));
        }
    }
    */
    for(int i=1; i<=row; ++i){
        for(int j=1; j<=col; ++j){
            datas[i][j]='#';
        }
    }

    for(int i=250; i<=750; ++i){
        for(int j=250; j<=750; ++j){
            datas[i][j]='.';
        }
    }

    for(int i=750; i<=1000; ++i)
        datas[500][i]='.';

    datas[500][500]='J';
    jihoon.push(pair<int, int>(500, 500));

    datas[500][499]=='F';
    fire.push(pair<int, int>(500, 499));

}

int bfs(int r, int c, queue<pair<int, int> >& jihoon, queue<pair<int, int> >& fire)
{
    int rowadd [4]={0, 1, 0, -1};
    int coladd [4]={1, 0, -1, 0};
    int row, col;



    queue<pair<int, int> > next_jihoon;
    queue<pair<int, int> > next_fire;
    vector<pair<int, int> > check;

    while(!(fire.empty())){
        row = fire.front().first;
        col = fire.front().second;
        fire.pop();

        for(int i=0; i<4; ++i){
            if(row+rowadd[i] >=1 && row+rowadd[i]<=r && col+coladd[i]>=1 && col+coladd[i]<=c){
                if( datas[row+rowadd[i]][col+coladd[i]] == 'J' || datas[row+rowadd[i]][col+coladd[i]]=='.'){
                    datas[row+rowadd[i]][col+coladd[i]]='F';
                    next_fire.push(pair<int,int>(row+rowadd[i], col+coladd[i]));
                }
            }
        }
    }



    while(!(jihoon.empty())){
        row = jihoon.front().first;
        col = jihoon.front().second;
        jihoon.pop();

        //cout << row << " " << col <<endl;

        for(int i=0; i<4; ++i){
            if(row+rowadd[i] >=0 && row+rowadd[i]<=r+1 && col+coladd[i]>=0 && col+coladd[i]<c+1){
                if( datas[row+rowadd[i]][col+coladd[i]]=='.'){
                    datas[row+rowadd[i]][col+coladd[i]]='J';
                    next_jihoon.push(pair<int,int>(row+rowadd[i], col+coladd[i]));
                }
                if( datas[row+rowadd[i]][col+coladd[i]]==0){
                    return 1;
                }
            }
        }
    }

    if(next_jihoon.empty()){
        cout << "IMPOSSIBLE" << endl;
        exit(1);
    }

    while(!(next_fire.empty()))
    {
        fire.push(next_fire.front());
        next_fire.pop();
    }


    while(!(next_jihoon.empty()))
    {
        jihoon.push(next_jihoon.front());
        next_jihoon.pop();
    }

    return 0;
}

void processing(istream& is, ostream& os)
{

    int row, col, check= 0, cnt=0;
    queue<pair<int, int> > jihoon;
    queue<pair<int, int> > fire;


    is >> row >> col;

    initialize(is, row, col, jihoon, fire);


    while(check==0){
        cnt++;
        check = bfs(row, col, jihoon, fire);
    }

    os << cnt << endl;



}
int main(void){

    processing(cin, cout);

    return 0;
}


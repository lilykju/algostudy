#include <bits/stdc++.h>
using namespace std;

void Init_Deck(list<int>& deck, int N)
{
    for(int i=1; i<=N; ++i)
        deck.push_back(i);
}


void Shuffle(list<int>& deck, int N)
{
    int half;
    list<int> half1, half2;

    if(N%2==1)
        half = N/2+1;
    else
        half = N/2;

    for(int i=0; i<half; ++i)
    {
        half1.push_back(deck.front());
        deck.pop_front();
    }
    while(!(deck.empty()))
    {
        half2.push_back(deck.front());
        deck.pop_front();
    }


    while(!(half1.empty()&&half2.empty()))
    {
        deck.push_back(half1.front());
        half1.pop_front();
        if(half2.empty())
            break;
        deck.push_back(half2.front());
        half2.pop_front();

    }
}

void Result(list<int>& deck, int N, ostream& os)
{
    list<int>::iterator first = deck.begin();
    list<int>::iterator middle = deck.begin();
    list<int>::iterator last = deck.begin();


    advance(middle, N/2-1);
    advance(last, N-1);

    os << *first << " "<<*middle << " " << *last << endl;

}

void Cut(list<int>& deck, int N, istream& is)
{
    list<int>::iterator cut_begin = deck.begin();
    list<int>::iterator cut_end = deck.begin();
    list<int>::iterator pos = deck.begin();
    list<int> cut;
    int left, right;
    is >> left >> right;

    advance(pos, left-1);
    for(int i=left-1; i<right; ++i)
    {
        cut.push_back(*pos);
        advance(pos,1);
    }

    advance(cut_begin, left-1);
    advance(cut_end, right);
    deck.erase(cut_begin, cut_end);

    while(!(cut.empty()))
    {
        deck.push_back(cut.front());
        cut.pop_front();
    }

}

void processing(istream& is, ostream& os)
{

    string funct;
    list<int> deck;
    int N, K;

    is >> N >> K;


    Init_Deck(deck, N);

    for(int i=0; i<K; ++i)
    {
        is >> funct;

        if(funct == "Shuffle")
            Shuffle(deck, N);

        if(funct == "Cut")
            Cut(deck, N, is);
    }

    Result(deck, N, os);

}

int main()
{
    ifstream ifs("card.inp");
    assert(ifs.is_open());
    ofstream ofs("card.out");
    assert(ofs.is_open());

    processing(ifs, ofs);

    ifs.close();
    ofs.close();
    return 0;
}

#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    unsigned long long a, b, c;
    cin >> a >> b >> c;
    unsigned long long cnt = 1;
    unsigned long long mula = a%c;
    while(b>0){
        if(b-cnt>=0){
            b-=cnt;
            mula *= mula;
            mula %= c;
            cnt*=2;
        } else{
            cnt = 1;
            b-=cnt;
            mula *= (a%c);
            mula %= c;
        }
    }
    cout << mula;
}
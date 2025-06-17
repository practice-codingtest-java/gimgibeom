#include<bits/stdc++.h>

using namespace std;

int main(){
    int n; cin >> n;
    if(n==0) {
        cout << 1;
        return 0;
    }
    if(n==1) {
        cout << 0;
        return 0;
    }
    string a;
    while(n>0){
        if(n - 2 >= 0){
            n-=2;
            a.push_back('8');
        } else {
            n-=1;
            a.push_back('8');
            a[0] = '4';
        }
    }
    cout << a;
}
#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    string a; cin >> a;
    for(int i = 0; i < a.length(); i++){
        if(a[i] >= 'a' && a[i] <= 'z'){
            a[i] = a[i] - 'a' + 'A';
        } else{
            a[i] = a[i] - 'A' + 'a';
        }
    }
    cout << a;
}
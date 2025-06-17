#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n; cin >> n;
    string a; cin >> a;
    int b = 0;
    int s = 0;
    while(a.length() >= 7){
        if(a.substr(0,8) == "security") {
            s++;
            a.erase(0,8);
        }
        if(a.substr(0,7) == "bigdata"){
            b++;
            a.erase(0,7);
        }
    }
    if(s>b){
        cout << "security!";
    } else if(s<b) {
        cout << "bigdata?";
    } else {
        cout << "bigdata? security!";
    }
}
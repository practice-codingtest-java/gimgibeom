#include<bits/stdc++.h>

using namespace std;

int main(){
    int n; cin >> n;
    for(int i = 0; i < 3; i++){
        double a,b,c; cin >> a >> b >> c;
        double d = a*b*c;
        d *= 100;
        d = round(d);
        d /= 100;
        cout << fixed;
        cout.precision(2);
        cout << "$" << d << "\n";
    }
}
#include<bits/stdc++.h>

using namespace std;

int main(){
    int x; cin >> x;
    int n; cin >> n;
    while(n--){
        int a,b; cin >> a >> b;
        x-=(a*b);
    }
    if(x==0){
        cout << "Yes";
    } else {
        cout << "No";
    }
}
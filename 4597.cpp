#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while (true)
    {
        string a; cin >> a;
        int cnt = 0;
        char perity = a.length()-1;
        if(a == "#") break;
        for(int i = 0; i < a.length()-1; i++){
            if(a[i] == '1') cnt++;
        }
        if(cnt%2 == 0){
            if(a[perity] == 'e'){
                a[perity] = '0';
            } else {
                a[perity] = '1';
            }
        } else {
            if(a[perity] == 'e'){
                a[perity] = '1';
            } else {
                a[perity] = '0';
            }
        }
        cout << a << "\n";
    }
    
}
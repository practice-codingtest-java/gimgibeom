#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n; cin >> n;
    for(int i = 0; i < n; i++){
        string a; cin >> a;
        for(int j = 0; j < a.length(); j++){
            if(a[j] >= 'A' && a[j] <= 'Z'){
                a[j] = a[j] - 'A' + 'a';
            }
        }
        cout << a << "\n";
    }
}
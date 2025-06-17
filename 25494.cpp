#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n; cin >> n;
    for(int i = 0; i < n; i++){
        int a,b,c; cin >> a >> b >> c;
        int cnt = 0;
        for(int j = 1; j <= a; j++){
            for(int k = 1; k <= b; k++){
                for(int l = 1; l <= c; l++){
                    if((j%k) == (k%l) && (k%l) == (l%j)) cnt++;
                }
            }
        }
        cout << cnt << "\n";
    }
}
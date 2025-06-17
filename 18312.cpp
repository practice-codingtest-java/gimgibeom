#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int a, b; cin >> a >> b;
    int cnt = 0;
    for(int i = 0; i <= a; i++){
        for(int j = 0; j < 60; j++){
            for(int k = 0; k < 60; k++){
                if(((i%10) == b) || ((i/10) ==b) || ((j%10)==b)||((j/10) ==b) || ((k%10)==b)||((k/10)==b))cnt++;
            }
        }
    }
    cout << cnt;
}
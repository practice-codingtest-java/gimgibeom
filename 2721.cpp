#include<bits/stdc++.h>

using namespace std;
int a[302];
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t; cin >> t;
    int sum = 0;
    for(int i = 1; i <= 301; i++){
        sum+=i;
        a[i] = sum;
    }
    while(t--){
        int n; cin >> n;
        int sum2 = 0;
        for(int i = 1; i <= n; i++){
            sum2+=i*a[i+1];
        }
        cout << sum2 << "\n";
    }
}
#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n; cin >> n;
    vector<int> a;
    for(int i = 0 ; i < n; i++){
        int tmp; cin >> tmp;
        a.push_back(tmp);
    }
    int m; cin >> m;
    int cnt = 0;
    for(int i = 0; i < n-1;i++){
        for(int j=i; j < n; j++){
            if(a[i]+a[j] == m) cnt++;
        }
    }
    cout << cnt;
}
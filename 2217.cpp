#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n; cin >> n;
    vector<int> v;
    for(int i = 0; i < n; i++){
        int tmp; cin >> tmp;
        v.push_back(tmp);
    }
    sort(v.begin(),v.end());
    int ans = 0;
    for(int i = 0; i < v.size(); i++){
        int tmp = (v.size()-i)*v[i];
        ans = max(ans,tmp);
    }
    cout << ans;
}
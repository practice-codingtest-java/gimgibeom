#include<bits/stdc++.h>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n; cin >> n;
    vector<int> v;
    for(int i = 0; i < n; i++){
        int tmp; cin >> tmp;
        v.push_back(tmp);
    }
    sort(v.begin(),v.end());
    int sum = 0;
    for(int i = 0; i < v.size()-1; i++){
        sum+=v[i];
    }
    cout << sum;
}
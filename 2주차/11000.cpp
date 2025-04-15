#include<bits/stdc++.h>

using namespace std;

bool compare1(pair<int,int> a, pair<int,int>b){
    if(a.second == b.second){
        return a.first > b.first;
    }
    return a.second > b.second;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    priority_queue<int,vector<int>, greater<int> > pq;
    vector<pair<int, int> > v;
    int n; cin >> n;
    while(n--){
        int start,end;
        cin >> start >> end;
        v.push_back(make_pair(start,end));
    }
    sort(v.begin(),v.end(),compare1);
    for(int i = 0; i < v.size(); i++){
        int start = v[i].first, end = v[i].second;
        // cout << v[i].first << " " << v[i].second << "\n";
        if(!pq.empty() && start >= pq.top()){
            pq.pop();
        }
        pq.push(end);
        // cout << pq.top();
    }
    cout << pq.size();
}
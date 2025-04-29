#include<bits/stdc++.h>

using namespace std;

int field[1001][1001];
int ans[1001][1001];
int checked[1001][1001];
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
queue<pair<int,int> > q;
int n,m;
void bfs(int y, int x){
    q.push(make_pair(y,x));
    while(!q.empty()){
        int py = q.front().first;
        int px = q.front().second;
        checked[y][x] = 1;
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = py + dx[i];
            int nx = px + dy[i];
            if(nx >=0 && ny >= 0 && nx < n && ny < m && (checked[ny][nx] == 0 ||(checked[ny][nx] == 1 && ans[ny][nx] > ans[py][px] + 1)) && field[ny][nx] != -1){
                checked[ny][nx] = 1;
                q.push(make_pair(ny,nx));
                if(ans[ny][nx] > ans[py][px]){
                    ans[ny][nx] = ans[py][px] + 1;
                }
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(0);
     cin >> n >> m;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> field[i][j];
            if(field[i][j] == 0){
                ans[i][j] = 1000000;
            }
        }
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(field[i][j] == 1 && !checked[i][j]){
                bfs(i,j);
            }
        }
    }
    int maxVal = 0;
    for(int i =0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(field[i][j] == 0){
                if(!checked[i][j]){
                    cout << -1; return 0;
                } else{
                    if(maxVal < ans[i][j]) maxVal = ans[i][j];
                }
            }
        }
    }
    cout << maxVal;
}
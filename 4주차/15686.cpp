#include<bits/stdc++.h>

using namespace std;
int n, m;
int board[52][52];

int answer = 2e9;

vector<pair<int, int> > chicken;
vector<pair<int, int> > home;


int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            cin >> board[i][j];

            if(board[i][j] == 2)
                chicken.push_back(make_pair(i,j));
            else if(board[i][j] == 1)
                home.push_back(make_pair(i,j));
        }
            
    }

    vector<int> permutation(chicken.size(), 1);
    
    // 치킨집 - m으로 순열을 돌릴 조합을 갱신한다.(0을 채워야 순열이 돌아가기 때문) 
    fill(permutation.begin(), permutation.begin() + chicken.size() - m, 0);

    do
    {
        int dist = 0;

        for (auto h : home)
        {
            int mn = 2e9;
            
            // 위에 Calc 함수와 비슷하게 계산해준다.
            for (int i = 0; i < chicken.size(); ++i)
            {
            	int cur = abs(chicken[i].first - h.first) + 
                          abs(chicken[i].second - h.second); 
                
                if (permutation[i])
                    mn = min(mn, cur);
            }

            dist += mn;
        }

        answer = min(dist, answer);


    } while(next_permutation(permutation.begin(), permutation.end()));


    cout << answer;
}
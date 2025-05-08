#include <bits/stdc++.h>
using namespace std;

const int MAX = 10;

int m, n, o, p, q, r, s, t, u, v, w;
int arr[MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX];
bool visited[MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX][MAX];

// 이동 방향: 22방향 (11차원 * 2방향씩)
int dx[11][2] = {
    {1, -1}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
    {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}
};

struct Node {
    int pos[11];
    int day;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // 입력
    cin >> m >> n >> o >> p >> q >> r >> s >> t >> u >> v >> w;
    vector<int> dims = {m, n, o, p, q, r, s, t, u, v, w};

    queue<Node> qnodes;

    // 입력 처리
    for (int wi = 0; wi < w; ++wi)
    for (int vi = 0; vi < v; ++vi)
    for (int ui = 0; ui < u; ++ui)
    for (int ti = 0; ti < t; ++ti)
    for (int si = 0; si < s; ++si)
    for (int ri = 0; ri < r; ++ri)
    for (int qi = 0; qi < q; ++qi)
    for (int pi = 0; pi < p; ++pi)
    for (int oi = 0; oi < o; ++oi)
    for (int ni = 0; ni < n; ++ni)
    for (int mi = 0; mi < m; ++mi) {
        int val;
        cin >> val;
        arr[mi][ni][oi][pi][qi][ri][si][ti][ui][vi][wi] = val;

        if (val == 1) {
            Node start;
            start.pos[0] = mi;
            start.pos[1] = ni;
            start.pos[2] = oi;
            start.pos[3] = pi;
            start.pos[4] = qi;
            start.pos[5] = ri;
            start.pos[6] = si;
            start.pos[7] = ti;
            start.pos[8] = ui;
            start.pos[9] = vi;
            start.pos[10] = wi;
            start.day = 0;
            qnodes.push(start);
            visited[mi][ni][oi][pi][qi][ri][si][ti][ui][vi][wi] = true;
        } else if (val == -1) {
            visited[mi][ni][oi][pi][qi][ri][si][ti][ui][vi][wi] = true;
        }
    }

    int maxDay = 0;

    while (!qnodes.empty()) {
        Node cur = qnodes.front(); qnodes.pop();
        maxDay = max(maxDay, cur.day);

        for (int d = 0; d < 11; ++d) {
            for (int dir = 0; dir < 2; ++dir) {
                Node next = cur;
                next.pos[d] += dx[d][dir];
                bool inBounds = true;

                for (int i = 0; i < 11; ++i) {
                    if (next.pos[i] < 0 || next.pos[i] >= dims[i]) {
                        inBounds = false;
                        break;
                    }
                }
                if (!inBounds) continue;

                if (!visited[
                    next.pos[0]][next.pos[1]][next.pos[2]][next.pos[3]][next.pos[4]]
                    [next.pos[5]][next.pos[6]][next.pos[7]][next.pos[8]][next.pos[9]][next.pos[10]]) {

                    visited[
                        next.pos[0]][next.pos[1]][next.pos[2]][next.pos[3]][next.pos[4]]
                        [next.pos[5]][next.pos[6]][next.pos[7]][next.pos[8]][next.pos[9]][next.pos[10]] = true;

                    next.day = cur.day + 1;
                    qnodes.push(next);
                }
            }
        }
    }

    // 미방문 토마토 있는지 확인
    for (int wi = 0; wi < w; ++wi)
    for (int vi = 0; vi < v; ++vi)
    for (int ui = 0; ui < u; ++ui)
    for (int ti = 0; ti < t; ++ti)
    for (int si = 0; si < s; ++si)
    for (int ri = 0; ri < r; ++ri)
    for (int qi = 0; qi < q; ++qi)
    for (int pi = 0; pi < p; ++pi)
    for (int oi = 0; oi < o; ++oi)
    for (int ni = 0; ni < n; ++ni)
    for (int mi = 0; mi < m; ++mi) {
        if (!visited[mi][ni][oi][pi][qi][ri][si][ti][ui][vi][wi]) {
            cout << -1 << '\n';
            return 0;
        }
    }

    cout << maxDay << '\n';
    return 0;
}

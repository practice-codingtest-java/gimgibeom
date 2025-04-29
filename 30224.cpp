#include<bits/stdc++.h>

using namespace std;

int main(){
    string a; cin >> a;
    int zeroflag = 1;
    for(int i = 0; i < a.length();i++){
        if(a[i] == '7'){
            zeroflag = 0;
            break;
        }
    }
    int twoflag =1;
    int b = stoi(a);
    if(b%7==0) twoflag = 0;
    if(zeroflag && twoflag) cout << 0;
    else if(zeroflag && !twoflag) cout << 1;
    else if(!zeroflag && twoflag) cout << 2;
    else cout << 3;
}
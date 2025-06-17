#include<bits/stdc++.h>

using namespace std;

int main(){
    int n; cin >> n;
    for(int i = 0; i < n; i++){
        int a; cin >> a;
        if((a+1)%(a%100) == 0){
            cout << "Good\n"; 
        } else {
            cout << "Bye\n";
        }
    }
}
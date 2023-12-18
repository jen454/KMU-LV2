#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int main() {
    int t;
    cin >> t;
    while(t--) {
        int n,num;
        int r=0;
        int s=0;
        int p=0;
        cin >> n;
        while(n--) {
            cin >> num;
            if (num == 1) s++;
            else if (num == 2) r++;
            else p++;
        }
        if (s!=0 && r!=0 && p!=0) cout << 0 << endl;
        else if ((s!=0 && r==0 && p==0) || (s==0 && r!=0 && p==0) || (s==0 && r==0 && p!=0)) cout << 0 << endl;
        else {
            if (s==0) cout << max(r,p) << endl;
            else if (r==0) cout << max(s,p) << endl;
            else cout << max(s,r) << endl;
        }
    }
    return 0;
}
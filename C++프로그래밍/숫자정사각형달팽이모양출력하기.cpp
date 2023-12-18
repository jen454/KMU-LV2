#include <iostream>
using namespace std;

int main() {
    int t,n,a,b;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> n >> a >> b;
        int cnt = 0;
        int num = 0;
        int dir = 0;
        int base = n;
        while (cnt != ((base*base)/2)+1) {
            if (dir == 0) {
                for (int j=0; j<n; j++) {
                    num++;
                    cnt++;
                    if ((cnt >= a) && (cnt <= b)) cout << num << " ";
                }
                n--;
                dir++;
            } if (dir == 1) {
                for (int j=0; j<n; j++) {
                    num += base;
                    cnt++;
                    if ((cnt >= a) && (cnt <= b)) cout << num << " ";
                }
                dir++;
            } if (dir == 2) {
                for (int j=0; j<n; j++) {
                    num--;
                    cnt++;
                    if ((cnt >= a) && (cnt <= b)) cout << num << " ";
                }
                n--;
                dir++;
            } if (dir == 3) {
                for (int j=0; j<n; j++) {
                    num -= base;
                    cnt++;
                    if ((cnt >= a) && (cnt <= b)) cout << num << " ";
                }
                dir = 0;
            }
            if (cnt >= b) break;
        }
        cout << "\n";
    }
    return 0;
}

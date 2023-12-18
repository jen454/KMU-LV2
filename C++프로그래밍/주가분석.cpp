#include <iostream>
using namespace std;

int main() {
    int t, n, num, base, cnt, high;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cnt = high = 0;
        cin >> n >> base;
        for (int i = 1; i < n; i++) {
            cin >> num;
            if (num > base && high == 0) {
                high++;
            } else if (num < base && high == 1) {
                high++;
            }
            if (high == 2) {
                cnt++;
                high = 0;
            }
            base = num;
        }
        cout << cnt << "\n";
    }
    return 0;
}

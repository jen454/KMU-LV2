#include <iostream>
using namespace std;
int main() {
    int t,n;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> n;
        int zero = 0;
        int one = 0;
        while(n>0) {
            if (n % 2 == 0) zero++;
            else one++;
            n /= 2;
        }
        cout << zero << " " << one << "\n";
    }
    return 0;
}
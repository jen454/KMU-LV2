#include <iostream>
using namespace std;

int main() {
    int t,r,s,x;
    cin >> t;
    while (t--) {
        cin >> r >> s >> x;
        int A_arr[r][s];
        int B_arr[s][x];
        for (int i=0; i<r; i++) {
            for (int j=0; j<s; j++) {
                cin >> A_arr[i][j];
            }
        }
        for (int i=0; i<s; i++) {
            for (int j=0; j<x; j++) {
                cin >> B_arr[i][j];
            }
        }
        for (int i=0; i<r; i++) {
            for (int j=0; j<x; j++) {
                int sum = 0;
                for (int k=0; k<s; k++) {
                    sum += A_arr[i][k] * B_arr[k][j];
                }
                cout << sum << " ";
            }
            cout << "\n";
        }
    }
    return 0;
}
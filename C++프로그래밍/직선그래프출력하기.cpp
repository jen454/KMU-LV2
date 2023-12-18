#include <iostream>
using namespace std;
int main() {
    int t,r;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> r;
        for (int j=0; j<r; j++) {
            for (int k=0; k<r; k++) {
                if (k == r/2 && j != r/2) cout << "I";
                else if (k != r/2 && j == r/2) cout << "+";
                else if (k == r/2 && j == r/2) cout << "O";
                else if (j+k == r-1) cout << "*";
                else cout << ".";
            }
            cout << "\n";
        }
    }
    return 0;
}
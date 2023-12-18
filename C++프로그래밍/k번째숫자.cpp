#include <iostream>
#include <string>
using namespace std;
int main() {
    int t,k;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> k;
        int base = 0;
        string str = "";
        while (true) {
            base++;
            str += to_string(base);
            if (str.length() >= k) break;
        }
        cout << str[k-1] << "\n";
    }
    return 0;
}
#include <iostream>
using namespace std;

bool Valid(string str) {
    if (isdigit(str[0])) {
        return false;
    }
    for (char c : str) {
        if (!isalnum(c) && c != '_') {
            return false;
        }
    }
    return true;
}

int main() {
    int t;
    string str;
    cin >> t;
    while (t--) {
        cin >> str;
        if (Valid(str)) cout << 1 << "\n";
        else cout << 0 << "\n";
    }
    return 0;
}

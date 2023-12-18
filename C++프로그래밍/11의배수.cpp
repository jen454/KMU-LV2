#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    int t;
    string str;
    cin >> t;
    while (t--) {
        cin >> str;
        string res = "";
        int arr[str.length()];
        int idx = 0;
        for (int i=0; i<str.length(); i++) {
            arr[i] = str[i]-'0';
        }
        for (int i=str.length()-1; i>0; i--) {
            if (i > 1) {
                arr[i-1] -= arr[i];
                if (arr[i-1] < 0) {
                arr[i-1] += 10;
                arr[i-2]--;
                }
                res += to_string(arr[i]);
            } else {
                arr[i-1] -= arr[i];
                res += to_string(arr[i]);
            }
        }
        reverse(res.begin(), res.end());
        for (int i = 0; i < res.length(); i++) {
            if (res[i] <= 48) continue;
            else {
                idx = i;
                break;
            }
        }
        res = res.substr(idx);
        if (arr[0]== 0) cout << res << "\n";
        else cout << 0 << "\n";
    }
    return 0;
}

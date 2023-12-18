#include <iostream>
using namespace std;
int main() {
    int t;
    cin >> t;
    while(t--) {
        int n,num,cnt;
        int sum = 1;
        cin >> n;
        while (n--) {
            cin >> num;
            sum *= num;
            sum %= 10;
        }
        cout << sum << "\n";
    }
    return 0;

}
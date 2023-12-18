#include <iostream>
using namespace std;
int main() {
    long long t,num,res;
    cin >> t;
    for (int i=0; i<t; i++) {
        res = 1;
        cin >> num;
        while (num / 10 != 0) {
            while (num != 0) {
                if (num % 10 != 0) res *= (num%10);
                num /= 10;
            }
            num = res;
            res = 1;
        }
        cout << num << "\n";
    }
    return 0;
}
#include <iostream>
using namespace std;
int main() {
    int t;
    cin >> t;
    while(t--) {
        int n,num;
        int sum=0;
        cin >> n;
        while(n--) {
            cin >> num;
            sum += num;
        }
        cout << sum << endl;
    }
    return 0;
}
// 변수 초기화 할때는 따로 하기
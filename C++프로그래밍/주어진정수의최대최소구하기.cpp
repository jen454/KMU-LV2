#include <iostream>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,num,min,max;
        cin >> n;
        cin >> num;
        min = num;
        max = num;
        for (int i=0; i<n-1; i++) {
            cin >> num;
            if (max < num) max = num;
            else if (min > num) min = num;
        }
        cout << max << " " << min << "\n";
    }
    return 0;
}
#include <iostream>
using namespace std;
int main() {
    int t,n,num;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> n;
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        int F=0;
        for (int j=0; j<n; j++) {
            cin >> num;
            if (num >= 1 && num <= 59) F++;
            else if (num >= 60 && num <= 69) D++;
            else if (num >= 70 && num <= 79) C++;
            else if (num >= 80 && num <= 89) B++;
            else A++;
        }
        cout << A << " " << B << " " << C << " " << D << " " << F << "\n";
    }
    return 0;
}
#include <iostream>
using namespace std;
int main() {
    int t,layer,sum,a,b,c,d;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> a >> b >> c >> d;
        if (d<a || b<c) {
            layer = 0;
            sum = (b-a) + (d-c);
        } else if (a<c && c<b && b<d) {
            layer = b-c;
            sum = d-a;
        } else if (c<a && a<d && d<b) {
            layer = d-a;
            sum = b-c;
        } else if (a<c && d<b) {
            layer = d-c;
            sum = b-a;
        } else if (c<a && b<d) {
            layer = b-a;
            sum = d-c;
        }
        cout << layer << " " << sum << "\n";
    }
    return 0;
}
#include <iostream>
using namespace std;
int main() {
    int t,px,py,qx,qy,Px,Py,Qx,Qy;
    int rad = 0;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> px >> py >> qx >> qy >> Px >> Py >> Qx >> Qy;
        int larea = (qx-px) * (qy-py);
        int rarea = (Qx-Px) * (Qy-Py);
        int interareax = max(0,min(qx,Qx)-max(px,Px));
        int interareay = max(0,min(qy,Qy)-max(py,Py));

        int interarea = interareax * interareay;
        int area = larea + rarea - interarea;
        
        if (interarea == 0) rad = ((qx-px) + (qy-py)) * 2 + ((Qx-Px) + (Qy-Py)) * 2;
        else rad = (((qx-px) + (qy-py)) + ((Qx-Px) + (Qy-Py)) - (interareax + interareay)) * 2;

        cout << area << " " << rad << "\n";
    }
    return 0;
}
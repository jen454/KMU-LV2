#include <iostream>
using namespace std;

int main() {
    int t,n;
    cin >> t;
    while (t--) {
        cin >> n;
        int arr[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = 0;
            }
        }
        int row=0; int col=n/2; int num=1;
        int copy_row = 0; int copy_col = 0;
        arr[row][col] = num;
        while (num < n*n) {
            copy_row = row; copy_col = col;
            if (row-1 < 0) {
                row = n-1; 
                if (col+1 == n) col = 0;
                else col++;
                num++;
                if (arr[row][col] == 0) arr[row][col] = num;
                else {
                    copy_row++;
                    row = copy_row; col = copy_col;
                    arr[row][col] = num;
                }
            } else {
                row--;
                if (col+1 == n) col = 0;
                else col++;
                num++;
                if (arr[row][col] == 0) arr[row][col] = num;
                else {
                    copy_row++;
                    row = copy_row; col = copy_col;
                    arr[row][col] = num;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                cout << arr[i][j] << " ";
            }
            cout << "\n";
        }     }
    return 0;
}
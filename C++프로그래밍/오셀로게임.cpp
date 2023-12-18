#include <iostream>
using namespace std;

int main() {
    int size = 8;
    char board[9][9];
    int dir[8][2] = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
    int T,n;
    cin >> T;

    while (T--) {
        for(int a = 1; a <= size; a++) {
            for(int b = 1; b <= size; b++) {
                board[a][b] = '+';
            }
        }   
        board[4][4] = 'O';
        board[5][5] = 'O';
        board[4][5] = 'X';
        board[5][4] = 'X';

        cin >> n;
        int O_cnt = 0, X_cnt = 0;
        
        char chr = 'X';
        while (n--) {
            int s,t;

            cin >> s;
            cin >> t;
            board[s][t] = chr;
            
            for(int c = 0; c < size; c++){
                int change_cnt = 0;
                int x = s;
                int y = t;
                while (true) {
                    x += dir[c][0];
                    y += dir[c][1];
                    
                    if (x >= 9 || y >= 9 || x <= 0 || y <= 0) {
                        change_cnt = 0;
                        break;   
                    }
                    else if (board[x][y] == '+') {
                        change_cnt = 0;
                        break;
                    }

                    else if (board[x][y] == chr) break; 

                    else change_cnt++;
                }
                for (int d = 1; d <= change_cnt; d++) {
                    int change_s = s + dir[c][0] * d;
                    int change_t = t + dir[c][1] * d;
                     
                    if (change_s >= 9 || change_t >= 9 || change_s <= 0 || change_t <= 0) {
                        change_cnt = 0;
                        break;   
                    }
                    board[change_s][change_t] = chr;
                }
            }
            if (chr == 'X') chr = 'O';
            else if (chr == 'O') chr = 'X';   
        }
        for (int a = 1; a <= size; a++) {
            for (int b = 1; b <= size; b++) {
                if (board[a][b] == 'X') X_cnt++;
                if (board[a][b] == 'O') O_cnt++;       
            }
        }
        cout << X_cnt << " " << O_cnt << "\n";
        for (int a = 1; a <= size; a++) {
            for (int b = 1; b <= size; b++) {
                cout << board[a][b];
            }
            cout << "\n";
        }
    }
    return 0;
}
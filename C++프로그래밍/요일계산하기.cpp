#include <iostream>
using namespace std;
int main() {
    int t,y,m,d;
    cin >> t;
    while (t--) {
        // 1582년 1월 1일 금요일
        // 1월 31 3월 31 4월 30 5월 31 6월 30 7월 31 8월 31 9월 30 10월 31 11월 30 12월 31
        int base = 0; // 1 == 윤년 0 == 윤년X 윤년일때 2월 29일
        int sum = 0;
        int month = 1;
        int year = 1582;
        string day = "";
        cin >> y >> m >> d;
        while (year != y) {
            if ((year%4==0 && year%100!=0) || year%400==0) sum += 366;
            else sum += 365;
            year++;
        }
        if ((y%4==0 && y%100!=0) || y%400==0) base = 1;
        switch (m) {
        case 1:
            sum += 0;
            break;
        case 2:
            sum += 31;
            break;
        case 3:
            if (base == 1) sum += 60;
            else sum += 59;
            break;
        case 4:
            if (base == 1) sum += 91;
            else sum += 90;
            break;
        case 5:
            if (base == 1) sum += 121;
            else sum += 120;
            break;
        case 6:
            if (base == 1) sum += 152;
            else sum += 151;
            break;
        case 7:
            if (base == 1) sum += 182;
            else sum += 181;
            break;
        case 8:
            if (base == 1) sum += 213;
            else sum += 212;
            break;
        case 9:
            if (base == 1) sum += 244;
            else sum += 243;
            break;
        case 10:
            if (base == 1) sum += 274;
            else sum += 273;
            break;
        case 11:
            if (base == 1) sum += 305;
            else sum += 304;
            break;
        case 12:
            if (base == 1) sum += 335;
            else sum += 334;
            break;
        }
        sum += d;
        switch (sum % 7) {
        case 1:
            day = "금요일";
            break;
        case 2:
            day = "토요일";
            break;
        case 3:
            day = "일요일";
            break;
        case 4:
            day = "월요일";
            break;
        case 5:
            day = "화요일";
            break;
        case 6:
            day = "수요일";
            break;
        case 0:
            day = "목요일";
            break;
        }
        if (day == "일요일") cout << 0 << "\n";
        else if (day == "월요일") cout << 1 << "\n";
        else if (day == "화요일") cout << 2 << "\n";
        else if (day == "수요일") cout << 3 << "\n";
        else if (day == "목요일") cout << 4 << "\n";
        else if (day == "금요일") cout << 5 << "\n";
        else if (day == "토요일") cout << 6 << "\n";
    }
    return 0;
} 
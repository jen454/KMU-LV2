#ifndef _MYRATIONAL_H_
#define _MYRATIONAL_H_
#include <iostream>
using namespace std;
class myRational
{
public:
    myRational(long num = 0, long den = 1);
    myRational(const myRational &rat);
    long getNumerator() const;
    long getDenominator() const;
    myRational reciprocal() const;
    // 분수와 분수, 분수와 정수의 사칙연산
    myRational operator +(const myRational &rat) const;
    myRational operator +(long value) const;
    myRational operator -(const myRational &rat) const;
    myRational operator -(long value) const;
    myRational operator *(const myRational &rat) const;
    myRational operator *(long value) const;
    myRational operator /(const myRational &rat) const;
    myRational operator /(long value) const;
    // 전위,후위 연산자
    myRational operator ++();
    myRational operator ++(int);
    myRational operator --();
    myRational operator --(int);
    // Unary
    myRational operator -();
    // Comparison Operators 
    bool operator ==(const myRational &rat) const;
    bool operator !=(const myRational &rat) const;
    bool operator >(const myRational &rat) const;
    bool operator >=(const myRational &rat) const;
    bool operator <(const myRational &rat) const;
    bool operator <=(const myRational &rat) const;
    
    // Assignment Operators 
    myRational& operator =(const myRational &rat);
    myRational& operator =(long value);
    myRational& operator +=(const myRational &rat);
    myRational& operator +=(long value);
    myRational& operator -=(const myRational &rat);
    myRational& operator -=(long value);
    myRational& operator *=(const myRational &rat);
    myRational& operator *=(long value);
    myRational& operator /=(const myRational& rat);
    myRational& operator /=(long value);
    // Input, Output Opeartors
    friend ostream &operator<<(ostream &outStream, const myRational &r);
    friend istream &operator>>(istream &inStream, myRational &r);
    friend myRational operator+(long value, const myRational &rat);
    friend myRational operator-(long value, const myRational &rat);
    friend myRational operator*(long value, const myRational &rat);
    friend myRational operator/(long value, const myRational &rat);
private:
    // 분수는 항상 내부적으로 기약분수로 표현하며, 또한 항상 _den>0 이다. 
    long _num;                // numerator
    long _den;                // denominator
    long gcd(long m, long n); // 최대공약수
    void reduce();
};
#endif
#include "MyRational.h"
using namespace std;

ostream &operator <<(ostream &outStream, const myRational& r)
{
    if (r._num == 0)
        outStream << 0;
    else if (r._den == 1)
        outStream << r._num;
    else
        outStream << r._num << "/" << r._den;
    return outStream;
}
istream &operator >>(istream &inStream, myRational& r)
{
    inStream >> r._num >> r._den;
    if (r._den == 0)
    {
    r._num = 0; 
    r._den = 1;
    }
    r.reduce();
    return inStream;
}
long myRational::gcd(long m, long n)
{
    if (m == n) return n;
    else if (m < n) return gcd(m, n-m);
    else return gcd(m-n, n);
}
void myRational::reduce()
{
    if (_num == 0 || _den == 0)
    {
    _num = 0;
    _den = 1;
    return;
    }
    if (_den < 0)
    {
    _den *= -1;
    _num *= -1;
    }
    if (_num == 1)
        return;
    int sgn = (_num < 0 ? -1 : 1);
    long g = gcd(sgn * _num, _den);
    _num /= g;
    _den /= g;
} 

myRational::myRational(long num, long den):_num(num), _den(den){
    reduce();
}
myRational::myRational(const myRational &rat) {
    _num = rat._num;
    _den = rat._den;
}
myRational myRational::reciprocal() const{
    return myRational(_den, _num);
}

long myRational::getNumerator() const {
    return _num;
}
long myRational::getDenominator() const {
    return _den;
}


myRational myRational::operator +(const myRational& rat) const {
    long new_den =  _den * rat._den;
    long new_num = _den * rat._num + rat._den * _num;
    return myRational (new_num, new_den);
}

myRational myRational::operator +(long value) const {
    return (*this) + myRational(value, 1);
}

myRational myRational::operator -(const myRational& rat) const {
    long new_den = _den *  rat._den;
    long new_num = (rat._den * _num) - (_den * rat._num);
    return myRational(new_num, new_den);
}

myRational myRational::operator -(long value) const {
    return (*this) - myRational(value, 1);
}

myRational myRational::operator *(const myRational& rat) const {
    long new_den = _den * rat._den;
    long new_num = _num * rat._num;
    return myRational(new_num, new_den);
}
myRational myRational::operator *(long value) const{
    return *this * myRational(value, 1);
}

myRational myRational::operator /(const myRational& rat) const {
    if (rat._num == 0) return myRational();
    myRational r = rat.reciprocal();
    long new_den = _den * r._den;
    long new_num = _num * r._num;
    return myRational(new_num, new_den);
}
myRational myRational::operator /(long value) const{
    return *this / myRational(value, 1);
}

// Overloaded unary operators
// unary minus
myRational myRational::operator -() {
    return myRational(-_num, _den);
}


myRational myRational::operator ++() {
    _num += _den;
    return *this;
}
myRational myRational::operator ++(int) {
    myRational ret(_num, _den);
    _num += _den;
    return ret;
}

myRational myRational::operator --() {
    _num -= _den;
    return *this;
}

myRational myRational::operator --(int) {
	myRational ret(_num, _den);
    _num -= _den;
    return ret;
}

// Overloading comparison operators
bool myRational::operator ==(const myRational& rat) const {
    return (_num == rat._num) && (_den == rat._den);
}

bool myRational::operator !=(const myRational& rat) const {
    return !operator==(rat);
}

bool myRational::operator >(const myRational& rat) const {

    return  rat._den * _num > _den * rat._num;
}

bool myRational::operator >=(const myRational& rat) const {
    return rat._den * _num >= _den * rat._num;
}

bool myRational::operator <(const myRational& rat) const {
    return rat._den * _num < _den * rat._num;
}

bool myRational::operator <=(const myRational& rat) const {
    return rat._den * _num <= _den * rat._num;
}

// Assignment operators
myRational& myRational::operator =(const myRational& rat) {
    _num = rat._num;
    _den = rat._den;
    return *this;
}

myRational& myRational::operator =(long value) {
    _num = value;
    _den = 1;
    return *this;
}

myRational& myRational::operator +=(const myRational& rat) {
    long new_num = _num;
    long new_den = _den;
    _num = (new_num * rat._den) + (rat._num * _den);
    _den = new_den * rat._den;
    reduce();
    return *this;
}
myRational& myRational::operator +=(long value){
    *this += myRational(value, 1);
    return *this;
}

myRational& myRational::operator -=(const myRational& rat) {
    long new_num = _num;
    long new_den = _den;
    _num = (new_num * rat._den) - (rat._num * _den);
    _den = new_den * rat._den;
    reduce();
    return *this;
}
myRational& myRational::operator -=(long value){
    *this -= myRational(value, 1);
    return *this;
}

myRational& myRational::operator *=(const myRational& rat) {
    long new_num = _num;
    long new_den = _den;
    _num = new_num * rat._num;
    _den = new_den * rat._den;
    reduce();
    return *this;
}
myRational& myRational::operator *=(long value){
    *this *= myRational(value, 1);
    return *this;
}
myRational& myRational::operator /=(const myRational& rat) {
    if (rat._num == 0){
        _num = 0;
        _den = 1;
        return *this;
    }
    long new_num = _num;
    long new_den = _den;
    myRational r(rat.reciprocal());
    _num = new_num * r._num;
    _den = new_den * r._den;
    reduce();
    return *this;
}
myRational& myRational::operator /=(long value){
    *this /= myRational(value, 1);
    return *this;
}

// private function
myRational operator +(long value, const myRational &rat) {
	return rat + value;
}

myRational operator-(long value, const myRational &rat) {
	myRational r(rat);
    return -r + value;
}

myRational operator*(long value, const myRational &rat) {
	return rat * value;
}
myRational operator/(long value, const myRational &rat) {
    myRational r(rat.reciprocal());
    return r * value;
}


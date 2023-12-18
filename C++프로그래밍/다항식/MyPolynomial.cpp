#include "MyPolynomial.h"
using namespace std;

MyPolynomial::MyPolynomial(int coeff, unsigned exp) {
    MyTerm term(coeff, exp);
    polynomial.push_back(term);
}
MyPolynomial::MyPolynomial(unsigned num_size, int *trems)  {
    for (int i=0; i<num_size; i++) {
        MyTerm term(trems[2*i], trems[2*i+1]);
        polynomial.push_back(term);
    }
    sort(polynomial.begin(), polynomial.end());
}
MyPolynomial::MyPolynomial(const MyPolynomial &poly) {
    for (int i=0; i<poly.polynomial.size(); i++) {
        MyTerm term(poly.polynomial[i]);
        polynomial.push_back(term);
    }
    sort(polynomial.begin(), polynomial.end());
}
MyPolynomial &MyPolynomial::operator=(const MyPolynomial &poly) {
    polynomial.clear();
    for (int i=0; i<poly.polynomial.size(); i++) {
        MyTerm term(poly.polynomial[i]);
        polynomial.push_back(term);
    }
    return *this;
}
int MyPolynomial::getDegree() const {
    return polynomial[0].exp;
}
unsigned MyPolynomial::getNumTerms() const {
    return polynomial.size();
}

MyPolynomial MyPolynomial::ddx() const {
    if (polynomial.size() == 1) {
        if (polynomial[0].exp != 0) {
            MyPolynomial dx(polynomial[0].coeff*polynomial[0].exp, polynomial[0].exp-1);
            return dx;
        }
        else {
            MyPolynomial dx(0, 0);
            return dx;
        }
    }
    int newNumTerms = polynomial.size() - 1;
    int terms[newNumTerms*2];
    for (int i=0; i<newNumTerms; i++) {
        terms[2*i] = polynomial[i].coeff*polynomial[i].exp;
        terms[2*i+1] = polynomial[i].exp-1;
    }
    MyPolynomial dx(newNumTerms, terms);
    return dx;
}

MyPolynomial &MyPolynomial::operator+=(const MyPolynomial &poly) {
    int pos_one=0, pos_two=0, size_one=polynomial.size(), size_two=poly.polynomial.size();
    while (pos_one < size_one && pos_two < size_two) {
        if (polynomial[pos_one] < poly.polynomial[pos_two]) pos_one++;
        else if (polynomial[pos_one] > poly.polynomial[pos_two]) polynomial.push_back(poly.polynomial[pos_two++]);
        else if (polynomial[pos_one].exp == poly.polynomial[pos_two].exp) polynomial[pos_one++].coeff += poly.polynomial[pos_two++].coeff;
    }
    if (pos_two != size_two) {
        for (int i=pos_two; i<size_two; i++) {
            polynomial.push_back(poly.polynomial[i]);
        }
    }
    vector<MyTerm>::iterator iter = polynomial.begin();
    while (iter != polynomial.end()) {
        if (!iter->coeff) polynomial.erase(iter);
        else iter++;
    }
    if (polynomial.empty()) {
        MyTerm term(0, 0);
        polynomial.push_back(term);
    }
    sort(polynomial.begin(), polynomial.end());
    return *this;
}
MyPolynomial &MyPolynomial::operator-=(const MyPolynomial &poly) {
    // 1, n^1000000000
    int pos_one=0, pos_two=0, size_one=polynomial.size(), size_two=poly.polynomial.size();
    while (pos_one < size_one && pos_two < size_two) {
        if (polynomial[pos_one] < poly.polynomial[pos_two]) pos_one++;
        else if (polynomial[pos_one] > poly.polynomial[pos_two]) polynomial.push_back(-poly.polynomial[pos_two++]);
        else if (polynomial[pos_one].exp == poly.polynomial[pos_two].exp) polynomial[pos_one++].coeff -= poly.polynomial[pos_two++].coeff;
    }
    if (pos_two != size_two) {
        for (int i=pos_two; i<size_two; i++) {
            polynomial.push_back(-poly.polynomial[i]);
        }
    }
    vector<MyTerm>::iterator iter = polynomial.begin();
    while (iter != polynomial.end()) {
        if (!iter->coeff) polynomial.erase(iter);
        else iter++;
    }
    if (polynomial.empty()) {
        MyTerm term(0, 0);
        polynomial.push_back(term);
    }
    sort(polynomial.begin(), polynomial.end());
    return *this;
}
MyPolynomial &MyPolynomial::operator*=(const MyTerm &term) {
    for (int i=0; i<polynomial.size(); i++) {
        polynomial[i].coeff *= term.coeff;
        polynomial[i].exp += term.exp;
    }
    return *this;
}
MyPolynomial &MyPolynomial::operator*=(const MyPolynomial &poly) {
    MyPolynomial ans;
    for (int i=0; i<polynomial.size(); i++) {
        MyPolynomial _poly(poly);
        _poly *= polynomial[i];
        ans += _poly;
    }
    return *this = ans;
}
MyPolynomial &MyPolynomial::operator*=(int size) {
    if (size == 0) {
        polynomial.clear();
        MyTerm term(0, 0);
        polynomial.push_back(term);
        return *this;
    }
    for (int i=0; i<polynomial.size(); i++) {
        polynomial[i].coeff *= size;
    }
    return *this;
}

MyPolynomial operator+(const MyPolynomial &poly1, const MyPolynomial &poly2) {
    MyPolynomial poly(poly1);
    return poly += poly2;
}
MyPolynomial operator-(const MyPolynomial &poly1, const MyPolynomial &poly2) {
    MyPolynomial poly(poly1);
    return poly -= poly2;
}
MyPolynomial operator*(const MyPolynomial &poly1, const MyTerm &term) {
    MyPolynomial poly(poly1);
    return poly *= term;
}
MyPolynomial operator*(const MyTerm &term, const MyPolynomial &poly1) {
    MyPolynomial poly(poly1);
    return poly *= term;
}
MyPolynomial operator*(const MyPolynomial &poly1, const MyPolynomial &poly2) {
    MyPolynomial poly(poly1);
    return poly *= poly2;
}
MyPolynomial operator*(const MyPolynomial &poly1, int size) {
    MyPolynomial poly(poly1);
    return poly *= size;
}
MyPolynomial operator*(int size, const MyPolynomial &poly1) {
    MyPolynomial poly(poly1);
    return poly *= size;
}

long MyPolynomial::operator()(int x) const {
    long ans = 0;
    for (int i=0; i<polynomial.size(); i++) {
        ans += polynomial[i].coeff * pow(x, polynomial[i].exp);
    }
    return ans;
}

MyPolynomial MyPolynomial::operator-() const {
    int num_size = polynomial.size();
    int terms[(num_size)*2];
    for (int i=0; i<num_size; i++) {
        terms[2*i] = -polynomial[i].coeff;
        terms[2*i+1] = polynomial[i].exp;
    }
    MyPolynomial poly(num_size, terms);
    return poly;
}

bool operator==(const MyPolynomial &poly1, const MyPolynomial &poly2) {
    if (poly1.polynomial[0] != poly2.polynomial[0]) return false;
    if (poly1.polynomial.size() != poly2.polynomial.size()) return false;
    for (int i=0; i<poly1.polynomial.size(); i++) {
        if (poly1.polynomial[i].coeff != poly2.polynomial[i].coeff) {
            return false;
        }
    }
    return true;
}
bool operator!=(const MyPolynomial &poly1, const MyPolynomial &poly2) {
    return !(poly1 == poly2);
}

ostream &operator<<(ostream &outstream, const MyPolynomial &poly) {
    for (int i=0; i<poly.polynomial.size(); i++) {
        MyTerm term = poly.polynomial[i];
        if (i && term.coeff > 0) cout << "+";
        if (term.exp > 1) {
            if (term.coeff != 1 && term.coeff != -1) {
                outstream << poly.polynomial[i].coeff << "x^" << poly.polynomial[i].exp;
            }
            else if (term.coeff == 1) {
                outstream << "x^" << poly.polynomial[i].exp;
            }
            else if (term.coeff == -1) {
                outstream << "-x^" << poly.polynomial[i].exp;
            }
        }
        else if (poly.polynomial[i].exp == 1) {
            if (term.coeff != 1 && term.coeff != -1) {
                outstream << poly.polynomial[i].coeff << "x";
            }
            else if (term.coeff == 1) {
                outstream << 'x';
            }
            else if (term.coeff == -1) {
                outstream << "-x";
            }
        }
        else if (poly.polynomial[i].exp == 0) {
            outstream << poly.polynomial[i].coeff;
        }
    }
    return outstream;
}

const MyPolynomial MyPolynomial::ZERO(0, 0);
const MyPolynomial MyPolynomial::ONE(1, 0);
const MyPolynomial MyPolynomial::X(1, 1);
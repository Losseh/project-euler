#include <map>
#include <iostream>

const int maxValue = 1000;
constexpr int maxSquareValue = 1000*1000;

struct triplet {
    int a;
    int b;
    int c;
};

triplet emptyResult(int a, int b) {
    return {a, b, -1};
}

std::map<int, int> getSquareToValueMap() {
    std::map<int, int> map;
    for (int i=1; i < maxValue; i++) {
        map[i*i] = i;
    }
    return map;
}

triplet check(int a, int b, const std::map<int, int>& squareToValueMap) {
    int cSquare = a*a + b*b;
    if (cSquare > maxSquareValue) {
        return emptyResult(a, b);
    }

    auto cEntry = squareToValueMap.find(cSquare);
    if (cEntry == squareToValueMap.end()) {
        return emptyResult(a, b);
    }
    int c = cEntry->second;

    if (a + b + c == 1000) {
        return {a, b, c};
    }

    return emptyResult(a, b);
}

triplet findTriplet(const std::map<int, int>& squareToValueMap) {
    triplet result;
    for (int a=1; a<=maxValue; a++) {
        for (int b=a; b<maxValue; b++ ) {
            
            result = check(a, b, squareToValueMap);
            if (result.c > 0) {
                return result;
            }

            // std::cout << "(" << a << ", " << b << ") wrong" << std::endl;
        }
    }

    return {-1, -1, -1};
}

int main() {
    std::map<int, int> squareToValueMap = getSquareToValueMap();
    triplet result = findTriplet(squareToValueMap);

    std::cout << result.a << ", " << result.b << ", " << result.c << std::endl;

    std::cout << "product = " << result.a * result.b * result.c << std::endl;
}
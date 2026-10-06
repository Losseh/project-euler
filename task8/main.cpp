#include <fstream>
#include <iostream>
#include <string>
#include <vector>

const std::string filePath = "input.txt";
const int windowLength = 13;

std::string readFile() {
    std::ifstream file{filePath};

    if (!file) {
        std::cerr << "Nie mogę otworzyć pliku\n";
        return "";
    }
    
    std::string content{
        std::istreambuf_iterator<char>{file},
        std::istreambuf_iterator<char>{}
    };

    return content;
}

std::vector<int> getDigits(std::string content, int start, int end) {
    std::vector<int> result;
    for (int i = start; i < end; i++) {
        result.push_back(content.at(i) - '0');
    }
    return result;
}

long multiply(std::vector<int> digits) {
    long result = 1;
    for(auto digit : digits) {
        result *= digit;
    }
    return result;
}

int main() {
    std::string fileContent = readFile();
    int length = fileContent.length();

    long greatestProduct = 0;
    for (int i = 0; i < length - windowLength; i++) {
        std::vector<int> digits = getDigits(fileContent, i, i + windowLength);
        for (int digit : digits) {
            std::cout << digit << ", ";
        }
        std::cout << '\n';
        long product = multiply(digits);
        if (product > greatestProduct) {
            greatestProduct = product;
        }
    }

    std::cout << greatestProduct << '\n';

    return 0;
}
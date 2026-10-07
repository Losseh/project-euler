#include <map>
#include <iostream>
#include <array>

const int size = 21;
using Matrix = std::array<std::array<long, 21>, 21>;

Matrix createMatrix() {

    Matrix matrix;
    
    // initialize
    for (int i=0; i < size; i++) {
        matrix[0][i] = 1;
        matrix[i][0] = 1;
    }

    return matrix;
}

void print(Matrix matrix) {
    for (int i=0; i < size; i++) {
        for (int j=0; j < size; j++) {
            std::cout << matrix[i][j] << " ";
        }
        std::cout << std::endl;
    }
}


int main() {

    Matrix matrix = createMatrix();

    for (int i = 1; i< size; i++) {
        std::cout << "computing row=" << i << std::endl;

        for (int j = i; j < size; j++) {
            matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            matrix[j][i] = matrix[i][j];
        }
    }

    print(matrix);

    std::cout << "result = " << std::endl;
}

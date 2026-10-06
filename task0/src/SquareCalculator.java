import java.math.BigInteger;

public class SquareCalculator {

    BigInteger getSquare(Integer number) {
        BigInteger square = new BigInteger(number.toString());
        return square.multiply(square);
    }
}

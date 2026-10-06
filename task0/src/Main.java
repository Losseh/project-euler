import java.math.BigInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int MAX_COUNT = 449000;

    public static void main(String[] args) {

        BigInteger sum = new BigInteger("0");
        SquareCalculator squareCalculator = new SquareCalculator();
        for (int i = 1; i <= MAX_COUNT; i++) {
            BigInteger square = squareCalculator.getSquare(i);
            if (square.testBit(0)) {
                sum = sum.add(square);
            }

            if ((i % 10000) == 0) {
                System.out.printf("-- %d%n", i);
            }
        }

        System.out.println(sum);
    }
}
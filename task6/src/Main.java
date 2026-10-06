//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int LIMIT = 100;

    public static void main(String[] args) {

        long sum = 0;
        long sumOfSquares = 0;
        for (int i = 1; i <= LIMIT; i++) {
            sum += i;
            sumOfSquares += i*i;
        }

        System.out.println(sum*sum - sumOfSquares);
    }
}
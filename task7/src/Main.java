import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int REQUIRED_SIZE = 10001;

    public static void main(String[] args) {
//        List<Long> primes = new ArrayList<>(10003);
//        primes.addAll(List.of(2L, 3L, 5L, 7L, 11L, 13L));

        long sum = 2;

        for (long i = 3; i < 2000000; i+=2) {

            if ((i - 1) % 1000 == 0) {
                System.out.printf("-- %d\n", i);
            }

            if (isPrime(i)) {
                sum += i;
//                primes.add(i);
            }
//            if (primes.size() == REQUIRED_SIZE) {
//                System.out.println(primes.size());
//                System.out.println(primes);
//                System.out.println(primes.get(primes.size() -1));
//                return;
//            }

        }

        System.out.println(sum);
    }

    private static boolean isPrime(long value) {
        for (int i = 3; i < (value / 2 + 1); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
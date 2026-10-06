import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final long INITIAL_VALUE = 600851475143L;

    public static void main(String[] args) {
        List<Long> primeFactors = findPrimeFactors(INITIAL_VALUE);
        System.out.println(primeFactors);
    }

    private static List<Long> findPrimeFactors(long value) {
        List<Long> primeFactors = new ArrayList<>();
        Long primeFactor;
        while (true) {
            primeFactor = findPrimeFactor(value);
            System.out.printf("-- primeFactor = %d\n", primeFactor);
            if (Objects.nonNull(primeFactor)) {
                value = value / primeFactor;
                primeFactors.add(primeFactor);
            } else {
                return primeFactors;
            }
        }
    }

    private static Long findPrimeFactor(long value) {
        System.out.printf("-- findPrimeFactor value = %d\n", value);
        if (value == 1) {
            return null;
        }

        for (long i = 2; i <= value; i++) {
            if (isDivisibleBy(value, i)) {
                return i;
            }
        }
        return null;
    }

    private static boolean isDivisibleBy(long value, long maybeDivisor) {
        return value % maybeDivisor == 0;
    }
}
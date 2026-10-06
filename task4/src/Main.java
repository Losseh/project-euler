import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> products = new ArrayList<>();

        for (int i = 999; i > 0; i--) {
            for (int j = 999; j >= i; j--) {
                int product = i * j;
                if (isPalindrome(product)) {
//                    System.out.printf("i = %d, j = %d, product = %d", i, j, product);
                    products.add(product);
                }
            }
        }
        System.out.println(products.stream().sorted().toList());
    }

    private static boolean isPalindrome(int value) {
        String asString = String.valueOf(value);
        String reversed = new StringBuilder(asString).reverse().toString();
        return asString.equals(reversed);
    }
}
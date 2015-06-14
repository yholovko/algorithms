package basic;

/**
 * Greatest common divisor (using Euclid's algorithm)
 */
public class GreatestCommonDivisor {
    private static int gcdRecursive(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcdRecursive(q, p % q);
    }

    private static int gcdNonRecursive(int p, int q) {
        while (q != 0) {
            int tmp = p % q;
            p = q;
            q = tmp;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(gcdRecursive(28, 12));
        System.out.println(gcdNonRecursive(28, 12));
    }
}
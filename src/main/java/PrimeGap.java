public class PrimeGap {

    // Method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find the first pair of primes with the given gap
    public static int[] gap(int g, int m, int n) {
        int previousPrime = -1;

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (previousPrime != -1 && i - previousPrime == g) {
                    return new int[] { previousPrime, i };
                }
                previousPrime = i;
            }
        }

        return null; // Return null if no such pair of primes is found
    }
}

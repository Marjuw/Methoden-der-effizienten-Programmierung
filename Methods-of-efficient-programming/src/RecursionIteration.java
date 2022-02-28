public class RecursionIteration {

    static int num = 10;
    static long runsOfFunction = 99999999l; //that the time to call is bigger enough to measure

    static long spendTimeRecursion;
    static long spendTimeIteration;

    // ----- Recursion -----
    // method to find factorial of given number
    static int factorialUsingRecursion(int n) {

        if (n == 0)
            return 1;

        // recursion call
        return n * factorialUsingRecursion(n - 1);
    }

    // ----- Iteration -----
    // Method to find the factorial of a given number
    static int factorialUsingIteration(int n) {

        int res = 1;

        // using iteration
        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    static void measureTimeOfRecursion() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {
            factorialUsingRecursion(num);
        }

        long end = System.currentTimeMillis();

        spendTimeRecursion = end - start;

    }

    static void measureTimeOfIteration() {

        long start = System.currentTimeMillis();

        for (long i = 0; i < runsOfFunction; i++) {
            factorialUsingIteration(num);
        }

        long end = System.currentTimeMillis();

        spendTimeIteration = end - start;

    }

    // Driver method
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            measureTimeOfRecursion();
            measureTimeOfIteration();

            System.out.println("\nRuntime in MS by Recursion:  " + spendTimeRecursion);
            System.out.println("Runtime in MS by Iteration:  " + spendTimeIteration);

        }
    }
}

